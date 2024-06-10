import torch
from transformers import GPT2LMHeadModel, GPT2Tokenizer
from datasets import load_dataset

# Load the fine-tuned model and tokenizer
model_path = "./method-test-generator"
model = GPT2LMHeadModel.from_pretrained(model_path)
tokenizer = GPT2Tokenizer.from_pretrained(model_path)

# Load the synthetic test dataset
dataset = load_dataset("jitx/Methods2Test_java_unit_test_code")
dataset["test"] = dataset["test"].select(range(10))

# Tokenize the test dataset
def tokenize_function_test(examples):
    return tokenizer(examples["src_fm"], padding="max_length", truncation=True, max_length=512)

tokenized_test_dataset = dataset["test"].map(tokenize_function_test, batched=True)

# Generate predictions
model.eval()  # Set model to evaluation mode
results = []

with torch.no_grad():
    for i, example in enumerate(tokenized_test_dataset):
        input_ids = torch.tensor(example["input_ids"]).unsqueeze(0)  # Add batch dimension
        attention_mask = torch.tensor(example["attention_mask"]).unsqueeze(0)  # Add batch dimension

        # Generate output
        outputs = model.generate(input_ids, attention_mask=attention_mask, max_length=1024)
        generated_text = tokenizer.decode(outputs[0], skip_special_tokens=True)

        # Print the input and the generated output
        original_text = tokenizer.decode(input_ids[0], skip_special_tokens=True)
        results.append(f"Input {i}: {original_text}")
        results.append(f"Generated Output {i}: {generated_text}")
        results.append("-----")

# Write results to a file
with open("test_results.txt", "w") as f:
    for line in results:
        f.write(line + "\n")

print("Testing complete. Results saved to 'test_results.txt'.")
