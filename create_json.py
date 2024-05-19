import json
import re

def create_json_from_file(input_file, output_file):
    # Initialize an empty list to hold the JSON entries
    data = []

    # Open the input file and read it line by line
    with open(input_file, 'r') as f:
        lines = f.readlines()

    # Initialize variables to hold the current requirement and name
    requirement = None
    name = None

    # Regular expression to match the pattern for names
    name_pattern = re.compile(r'### HLR-DPR_CHECK-\d{5} - (.+)')

    # Iterate through each line in the file
    for line in lines:
        # Check if the line matches the name pattern
        match = name_pattern.match(line.strip())
        if match:
            name = match.group(1)
        elif "The CSCI shall check" in line:
            requirement = line.strip()
            if name and requirement:
                # Construct the output path using the name
                output_path = f"hlt/dpr_check_hlt_{name}.feature"
                # Create a JSON entry and add it to the data list
                data.append({
                    "requirement": requirement,
                    "output_path": output_path,
                    "name": name
                })
                # Reset the requirement and name for the next entry
                requirement = None
                name = None

    # Write the data to the output JSON file
    with open(output_file, 'w') as json_file:
        json.dump(data, json_file, indent=4)

# Example usage
input_file = 'semantic_checks.md'
output_file = 'raw-data.json'
create_json_from_file(input_file, output_file)
