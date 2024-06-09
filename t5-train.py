import torch
from transformers import T5ForConditionalGeneration, T5Tokenizer, Trainer, TrainingArguments
from datasets import load_dataset

# Load the synthetic dataset
dataset = load_dataset("jitx/Methods2Test_java_unit_test_code")

dataset["train"] = dataset["train"].select(range(600))
dataset["test"] = dataset["test"].select(range(160))

# Tokenize the dataset
tokenizer = T5Tokenizer.from_pretrained("t5-small")

def tokenize_function(examples):
    src_text = examples["src_fm"]
    target_text = examples["target"]
    inputs = tokenizer(src_text, return_tensors="pt", padding=True, truncation=True, max_length=1024)
    labels = tokenizer(target_text, return_tensors="pt", padding=True, truncation=True, max_length=1024)
    return {"input_ids": inputs.input_ids, "labels": labels.input_ids}

tokenized_dataset = dataset.map(tokenize_function, batched=True)

tokenized_dataset = tokenized_dataset.remove_columns(["target", "src_fm", "src_fm_fc", "src_fm_fc_co", "src_fm_fc_ms", "src_fm_fc_ms_ff"])

tokenized_dataset.set_format("torch")

# Initialize the model
model = T5ForConditionalGeneration.from_pretrained("t5-small")
model.resize_token_embeddings(len(tokenizer))

# Define the training arguments
training_args = TrainingArguments(
    output_dir='./method-test-generator-t5.1',
    evaluation_strategy="epoch",
    learning_rate=5e-5,
    lr_scheduler_type="linear",
    weight_decay=0.01,
    per_device_train_batch_size=1,
    per_device_eval_batch_size=1,
    gradient_accumulation_steps=2,
    num_train_epochs=3,
    save_total_limit=2,
    logging_dir='./logs',
    logging_steps=10,
    warmup_ratio=0.1,
    remove_unused_columns=False,
    fp16=True,
    optim="adamw_torch",
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
model.save_pretrained("./method-test-generator-t5.1")
tokenizer.save_pretrained("./method-test-generator-t5.1")
