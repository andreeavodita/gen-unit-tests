import os
import torch
from transformers import T5ForConditionalGeneration, T5Tokenizer
from datasets import load_dataset

model_path = "./method-test-generator-t5.2"
model = T5ForConditionalGeneration.from_pretrained(model_path)
tokenizer = T5Tokenizer.from_pretrained(model_path)

dataset = load_dataset("jitx/Methods2Test_java_unit_test_code")
dataset["test"] = dataset["test"].select(range(100))

def tokenize_function_test(examples):
    return tokenizer(examples["src_fm_fc_ms_ff"], padding=True, return_tensors="pt", truncation=True, max_length=512)

tokenized_test_dataset = dataset["test"].map(tokenize_function_test, batched=True)

output_dir = "java_test_results_src_fm_fc_ms_ff"
os.makedirs(output_dir, exist_ok=True)

model.eval()

with torch.no_grad():
    for i, example in enumerate(tokenized_test_dataset):
        input_ids = torch.tensor(example["input_ids"]).unsqueeze(0)  # Add batch dimension
        attention_mask = torch.tensor(example["attention_mask"]).unsqueeze(0)  # Add batch dimension

        outputs = model.generate(input_ids, attention_mask=attention_mask, max_length=512)
        generated_text = tokenizer.decode(outputs[0], skip_special_tokens=True)

        original_text = tokenizer.decode(input_ids[0], skip_special_tokens=True)

        java_file_content = f"/*\n{original_text}\n*/\n\n{generated_text}"

        file_path = os.path.join(output_dir, f"test_case_{i+1}.java")
        with open(file_path, "w") as file:
            file.write(java_file_content)

print(f"Testing complete. Results saved to '{output_dir}' directory.")
