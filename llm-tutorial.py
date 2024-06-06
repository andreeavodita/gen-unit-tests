import torch
from datasets import load_dataset
from peft import LoraConfig, get_peft_model, prepare_model_for_kbit_training
from transformers import AutoModelForCausalLM, AutoTokenizer, TrainingArguments, BitsAndBytesConfig
from trl import SFTTrainer, SFTConfig

def train():
    train_dataset = load_dataset("tatsu-lab/alpaca", split="train")

    quantization_config = BitsAndBytesConfig(llm_int8_enable_fp32_cpu_offload=True)

    tokenizer = AutoTokenizer.from_pretrained("Salesforce/xgen-7b-8k-base", trust_remote_code=True)
    tokenizer.pad_token = tokenizer.eos_token
    model = AutoModelForCausalLM.from_pretrained(
        "Salesforce/xgen-7b-8k-base", torch_dtype=torch.float16, device_map="auto", quantization_config=quantization_config
    )

    model.resize_token_embeddings(len(tokenizer))
    model = prepare_model_for_kbit_training(model)
    peft_config = LoraConfig(r=16, lora_alpha=32, lora_dropout=0.05, bias="none", task_type="CAUSAL_LM")
    model = get_peft_model(model, peft_config)

    training_args = TrainingArguments(
        output_dir="xgen-7b-tuned-alpaca",
        overwrite_output_dir=True,
        per_device_train_batch_size=4,
        optim="adamw_torch",
        logging_steps=100,
        learning_rate=2e-4,
        fp16=True,
        warmup_ratio=0.1,
        lr_scheduler_type="linear",
        num_train_epochs=1,
        save_strategy="epoch",
        # push_to_hub=True,
    )

    sft_config = SFTConfig(
        output_dir="xgen-7b-tuned-alpaca",
        dataset_text_field="text",
    )

    trainer = SFTTrainer(
        model=model,
        train_dataset=train_dataset,
        tokenizer=tokenizer,
        args=training_args,
        peft_config=peft_config,
        packing=True,
        max_seq_length=1024,
        # sft_config=sft_config
    )

    trainer.train()
    # trainer.push_to_hub()

if __name__ == "__main__":
    train()
