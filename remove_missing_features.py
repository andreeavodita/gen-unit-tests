import json
import os

def detect_and_remove_missing_feature_files(json_file, folder_path, output_json_file):
    # Load JSON data
    with open(json_file, 'r') as f:
        data = json.load(f)

    # List to store entries with existing files
    valid_entries = []

    # Check existence of each feature file
    for entry in data:
        output_path = entry.get('output_path', None)
        if output_path:
            if os.path.exists(output_path):
                valid_entries.append(entry)
            else:
                print(f"Missing file: {output_path}")

    # Save the valid entries back to a JSON file
    with open(output_json_file, 'w') as f:
        json.dump(valid_entries, f, indent=4)

    return valid_entries

# Example usage
json_file = 'data.json'       # Input JSON file
folder_path = 'hlt'           # Folder where the feature files are located
output_json_file = 'data_cleaned.json'  # Output JSON file with missing entries removed

valid_entries = detect_and_remove_missing_feature_files(json_file, folder_path, output_json_file)

if valid_entries:
    print("Valid entries have been saved to the new JSON file.")
else:
    print("No valid entries found.")
