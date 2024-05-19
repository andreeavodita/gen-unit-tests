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

def preprocess_function(examples, max_length):
    inputs = [f"Requirement: {req}" for req in examples['requirement']]
    model_inputs = tokenizer(inputs, max_length=max_length, truncation=True, padding="max_length")

    # Read and tokenize the output content from files
    outputs = []
    for path in examples['output_path']:
        with open(path, 'r') as f:
            content = f.read()
            outputs.append(content)

    with tokenizer.as_target_tokenizer():
        labels = tokenizer(outputs, max_length=max_length, truncation=True, padding="max_length")

    model_inputs['labels'] = labels['input_ids']
    return model_inputs

def train_model(tokenizer, model, train_dataset, eval_dataset, training_args, max_length):
    tokenized_train_dataset = train_dataset.map(lambda examples: preprocess_function(examples, max_length), batched=True)
    tokenized_eval_dataset = eval_dataset.map(lambda examples: preprocess_function(examples, max_length), batched=True)

    trainer = Trainer(
        model=model,
        args=training_args,
        train_dataset=tokenized_train_dataset,
        eval_dataset=tokenized_eval_dataset
    )

    trainer.train()

    # Save the trained model
    model.save_pretrained(training_args.output_dir)

def load_trained_model(output_dir):
    return AutoModelForSeq2SeqLM.from_pretrained(output_dir)

def predict(model, tokenizer, dataset, max_length):
    tokenized_dataset = dataset.map(lambda examples: preprocess_function(examples, max_length), batched=True)
    trainer = Trainer(model=model, tokenizer=tokenizer)
    predictions = trainer.predict(test_dataset=tokenized_dataset)

    # Access predictions within the tuple and convert to a list of lists of token IDs
    predictions_token_ids = predictions.predictions

    # Decode the token IDs into text
    decoded_texts = tokenizer.batch_decode(predictions_token_ids, skip_special_tokens=True)

    return decoded_texts

# Define paths and file names
data_file = 'data_cleaned.json'
small_data_file = 'small-data.json'
output_dir = "./trained_model"

# Load pre-trained tokenizer and model
model_name = "google/t5-efficient-tiny"
tokenizer = AutoTokenizer.from_pretrained(model_name)
model = AutoModelForSeq2SeqLM.from_pretrained(model_name)

# Define training arguments
training_args = TrainingArguments(
    output_dir=output_dir,
    evaluation_strategy="epoch",
    learning_rate=2e-5,
    per_device_train_batch_size=1,
    per_device_eval_batch_size=1,
    num_train_epochs=3,
    weight_decay=0.01,
    gradient_accumulation_steps=1,
    fp16=True
)

# Load or prepare datasets
datasets = load_my_complex_data(small_data_file)
split_datasets = datasets['train'].train_test_split(test_size=0.2)  # 20% for testing

# Train the model
# train_model(tokenizer, model, split_datasets['train'], split_datasets['test'], training_args, max_length=512)

# Load the trained model
trained_model = load_trained_model(output_dir)

# Define prediction hyperparameters
max_length_prediction = 32  # Different max length for prediction

# Predict with the trained model
predictions = predict(trained_model, tokenizer, split_datasets['test'], max_length_prediction)

# Print some sample outputs
for i, pred in enumerate(predictions[:5]):
    print(f"Example {i + 1}:")
    print(f"Requirement: {split_datasets['test'][i]['requirement']}")
    print(f"Generated Output: {pred}")
    print(f"Actual Output Path: {split_datasets['test'][i]['output_path']}")
    print()
