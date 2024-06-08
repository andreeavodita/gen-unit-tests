import torch
from datasets import load_dataset
from peft import LoraConfig, get_peft_model, prepare_model_for_kbit_training
from transformers import AutoModelForCausalLM, AutoTokenizer, TrainingArguments, BitsAndBytesConfig
from trl import SFTTrainer

def train():
    train_dataset = load_dataset('json', data_files="English_text.jsonl", split='train')

    quantization_config = BitsAndBytesConfig(
        load_in_4bit=True,
        bnb_4bit_use_double_quant=True,
        bnb_4bit_quant_type="nf4",
        bnb_4bit_compute_dtype=torch.bfloat16,
        llm_int8_enable_fp32_cpu_offload=True
    )

    tokenizer = AutoTokenizer.from_pretrained("gpt2", trust_remote_code=True)
    tokenizer.pad_token = tokenizer.eos_token

    model = AutoModelForCausalLM.from_pretrained(
        "gpt2",
        torch_dtype=torch.float16,
        device_map="auto",
        quantization_config=quantization_config,
        offload_folder="llm_offload",
    )

    model.resize_token_embeddings(len(tokenizer))
    model = prepare_model_for_kbit_training(model)

    peft_config = LoraConfig(
        r=16,
        lora_alpha=32,
        lora_dropout=0.05,
        bias="none",
        task_type="CAUSAL_LM"
    )

    model = get_peft_model(model, peft_config)

    training_args = TrainingArguments(
        output_dir="gpt2-tuned",
        per_device_train_batch_size=4,
        gradient_accumulation_steps=8,
        optim="adamw_torch",
        logging_steps=100,
        learning_rate=2e-4,
        fp16=True,
        warmup_ratio=0.1,
        lr_scheduler_type="linear",
        num_train_epochs=10,
        save_strategy="epoch",
        push_to_hub=True,
    )

    trainer = SFTTrainer(
        model=model,
        train_dataset=train_dataset,
        dataset_text_field="text",
        max_seq_length=1024,
        tokenizer=tokenizer,
        args=training_args,
        packing=True,
        peft_config=peft_config,
    )

    trainer.train()
    trainer.push_to_hub()

if __name__ == "__main__":
    train()
