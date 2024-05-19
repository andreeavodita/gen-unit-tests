import json
import os

def detect_missing_feature_files(json_file, folder_path):
    # Load JSON data
    with open(json_file, 'r') as f:
        data = json.load(f)

    missing_files = []

    # Check existence of each feature file
    for entry in data:
        output_path = entry.get('output_path', None)
        if output_path:
            if not os.path.exists(output_path):
                missing_files.append(output_path)

    return missing_files

# Example usage
json_file = 'data.json'
folder_path = 'hlt'
missing_files = detect_missing_feature_files(json_file, folder_path)

if missing_files:
    print("Missing feature files:")
    for file in missing_files:
        print(file)
else:
    print("All feature files are present.")
