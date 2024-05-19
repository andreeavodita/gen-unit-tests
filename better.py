import json
from datasets import Dataset, DatasetDict
from transformers import AutoTokenizer, AutoModelForSeq2SeqLM, Trainer, TrainingArguments

def load_my_complex_data(data_file):
    with open(data_file, 'r') as f:
        data = json.load(f)

    # Convert list of dicts to Dataset
    dataset = Dataset.from_list(data)

    # Split the dataset if necessary (here we just duplicate it for illustration)
    dataset_dict = DatasetDict({
        'train': dataset,
        'test': dataset
    })

    return dataset_dict

# Example usage
data_file = 'data.json'
datasets = load_my_complex_data(data_file)
print(datasets)

split_datasets = datasets['train'].train_test_split(test_size=0.2)  # 20% for testing
print(split_datasets)

# Load pre-trained tokenizer and model
model_name = "t5-small"  # Change this to the model you want to fine-tune
tokenizer = AutoTokenizer.from_pretrained(model_name)
model = AutoModelForSeq2SeqLM.from_pretrained(model_name)

# Tokenize dataset
def preprocess_function(examples):
    inputs = [f"Requirement: {req}" for req in examples['requirement']]
    model_inputs = tokenizer(inputs, max_length=512, truncation=True, padding="max_length")

    # Read and tokenize the output content from files
    outputs = []
    for path in examples['output_path']:
        with open(path, 'r') as f:
            content = f.read()
            outputs.append(content)

    with tokenizer.as_target_tokenizer():
        labels = tokenizer(outputs, max_length=512, truncation=True, padding="max_length")

    model_inputs['labels'] = labels['input_ids']
    return model_inputs

tokenized_datasets = split_datasets.map(preprocess_function, batched=True)

# Define training arguments
training_args = TrainingArguments(
    output_dir="./results",
    evaluation_strategy="epoch",
    learning_rate=2e-5,
    per_device_train_batch_size=4,
    per_device_eval_batch_size=4,
    num_train_epochs=3,
    weight_decay=0.01,
)

# Create Trainer instance
trainer = Trainer(
    model=model,
    args=training_args,
    train_dataset=tokenized_datasets['train'],
    eval_dataset=tokenized_datasets['test']
)

# Fine-tune the model
trainer.train()

