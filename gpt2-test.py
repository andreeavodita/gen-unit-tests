import json
import torch
from transformers import GPT2LMHeadModel, GPT2Tokenizer, Trainer, TrainingArguments

# Load the dataset
with open('English_text.jsonl') as f:
    data = json.load(f)

# Prepare the data for training
train_texts = []
train_labels = []

for item in data:
    prompt = item['prompt']
    canonical_solution = item['test']
    if canonical_solution:
        train_texts.append(prompt)
        train_labels.append(canonical_solution)

# Load pretrained model and tokenizer
model_name = 'gpt2'  # Or 'distilgpt2' for a smaller model
tokenizer = GPT2Tokenizer.from_pretrained(model_name)
model = GPT2LMHeadModel.from_pretrained(model_name)

# Tokenize the inputs
train_encodings = tokenizer(train_texts, truncation=True, padding=True, max_length=512)
train_labels = tokenizer(train_labels, truncation=True, padding=True, max_length=512)['input_ids']

# Prepare the dataset for Trainer
class CodeDataset(torch.utils.data.Dataset):
    def __init__(self, encodings, labels):
        self.encodings = encodings
        self.labels = labels

    def __getitem__(self, idx):
        item = {key: torch.tensor(val[idx]) for key, val in self.encodings.items()}
        item['labels'] = torch.tensor(self.labels[idx])
        return item

    def __len__(self):
        return len(self.labels)

train_dataset = CodeDataset(train_encodings, train_labels)

# Define training arguments
training_args = TrainingArguments(
    output_dir='./my-gpt2',
    num_train_epochs=3,
    per_device_train_batch_size=2,
    per_device_eval_batch_size=2,
    warmup_steps=500,
    weight_decay=0.01,
    logging_dir='./logs',
    logging_steps=10,
)

# Create Trainer
trainer = Trainer(
    model=model,
    args=training_args,
    train_dataset=train_dataset,
)

# Train the model
trainer.train()
