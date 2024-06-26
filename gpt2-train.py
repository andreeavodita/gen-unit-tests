import torch
from transformers import GPT2LMHeadModel, GPT2Tokenizer, Trainer, TrainingArguments
from datasets import load_dataset

# Load the synthetic dataset
dataset = load_dataset("jitx/Methods2Test_java_unit_test_code")

dataset["train"] = dataset["train"].select(range(600))
dataset["test"] = dataset["test"].select(range(50))

# Tokenize the dataset
tokenizer = GPT2Tokenizer.from_pretrained("gpt2")
tokenizer.pad_token = tokenizer.eos_token

def tokenize_function(examples):
    src_tokens = tokenizer(examples["src_fm"], return_tensors='pt', padding=True, truncation=True, max_length=512)
    target_tokens = tokenizer(examples["target"], return_tensors='pt', padding=True, truncation=True, max_length=512)
    return {"input_ids": src_tokens.input_ids, "labels": target_tokens.input_ids}

tokenized_dataset = dataset.map(tokenize_function, batched=True)

tokenized_dataset = tokenized_dataset.remove_columns(["target", "src_fm", "src_fm_fc", "src_fm_fc_co", "src_fm_fc_ms", "src_fm_fc_ms_ff"])

tokenized_dataset.set_format("torch")

# Initialize the model
model = GPT2LMHeadModel.from_pretrained("gpt2")
model.resize_token_embeddings(len(tokenizer))

# Define the training arguments
training_args = TrainingArguments(
    output_dir='./method-test-generator',
    evaluation_strategy="epoch",
    learning_rate=2e-5,
    weight_decay=0.01,
    per_device_train_batch_size=1,
    per_device_eval_batch_size=1,
    # optim="adamw_torch",
    num_train_epochs=3,
    save_total_limit=2,
    logging_dir='./logs',
    logging_steps=10,
    remove_unused_columns=False,
    fp16=True,
)

# Initialize the trainer
trainer = Trainer(
    model=model,
    args=training_args,
    train_dataset=tokenized_dataset['train'],
    eval_dataset=tokenized_dataset['test'],
)

# Train the model
trainer.train()

# Save the fine-tuned model and tokenizer
model.save_pretrained("./method-test-generator")
tokenizer.save_pretrained("./method-test-generator")
