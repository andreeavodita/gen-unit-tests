import nltk
import evaluate
import numpy as np
from datasets import load_dataset
from transformers import T5Tokenizer, DataCollatorForSeq2Seq
from transformers import T5ForConditionalGeneration, Seq2SeqTrainingArguments, Seq2SeqTrainer

MODEL_NAME = "google/flan-t5-small"

tokenizer = T5Tokenizer.from_pretrained(MODEL_NAME)
model = T5ForConditionalGeneration.from_pretrained(MODEL_NAME)
data_collator = DataCollatorForSeq2Seq(tokenizer=tokenizer, model=model)

DATA_NAME = "jitx/Methods2Test_java_unit_test_code"
methods2test = load_dataset(DATA_NAME)

methods2test = methods2test["train"].train_test_split(test_size=0.3)

print(methods2test)

# We prefix our tasks with "answer the question"
# prefix = "Please answer this question: "

# Define the preprocessing function

def preprocess_function(examples):
   # """Add prefix to the sentences, tokenize the text, and set the labels"""
   # The "inputs" are the tokenized answer:
   # inputs = [prefix + doc for doc in examples["question"]]
   print(examples["code"])

   # my_variable = examples

   # data_type = type(my_variable)
   # print("Data type:", data_type)

   # Check if it's a dictionary
   # if isinstance(my_variable, dict):
   #  print("It's a dictionary!")
   #  # If it's a dictionary, you can print its keys
   #  print("Keys:", my_variable.keys())
   # # model_inputs = tokenizer(inputs, max_length=128, truncation=True)

   # # The "labels" are the tokenized outputs:
   # labels = tokenizer(text_target=examples["answer"],
   #                    max_length=512,
   #                    truncation=True)

   # model_inputs["labels"] = labels["input_ids"]
   # return model_inputs

# Map the preprocessing function across our dataset
tokenized_dataset = methods2test.map(preprocess_function, batched=True)

# nltk.download("punkt", quiet=True)
# metric = evaluate.load("rouge")

# def compute_metrics(eval_preds):
#    preds, labels = eval_preds

#    # decode preds and labels
#    labels = np.where(labels != -100, labels, tokenizer.pad_token_id)
#    decoded_preds = tokenizer.batch_decode(preds, skip_special_tokens=True)
#    decoded_labels = tokenizer.batch_decode(labels, skip_special_tokens=True)

#    # rougeLSum expects newline after each sentence
#    decoded_preds = ["\n".join(nltk.sent_tokenize(pred.strip())) for pred in decoded_preds]
#    decoded_labels = ["\n".join(nltk.sent_tokenize(label.strip())) for label in decoded_labels]

#    result = metric.compute(predictions=decoded_preds, references=decoded_labels, use_stemmer=True)

#    return result

# # Global Parameters
# L_RATE = 3e-4
# BATCH_SIZE = 4
# PER_DEVICE_EVAL_BATCH = 4
# WEIGHT_DECAY = 0.01
# SAVE_TOTAL_LIM = 3
# NUM_EPOCHS = 3

# # Set up training arguments
# training_args = Seq2SeqTrainingArguments(
#    output_dir="./results",
#    evaluation_strategy="epoch",
#    learning_rate=L_RATE,
#    per_device_train_batch_size=BATCH_SIZE,
#    per_device_eval_batch_size=PER_DEVICE_EVAL_BATCH,
#    weight_decay=WEIGHT_DECAY,
#    save_total_limit=SAVE_TOTAL_LIM,
#    num_train_epochs=NUM_EPOCHS,
#    predict_with_generate=True,
#    push_to_hub=False
# )

# trainer = Seq2SeqTrainer(
#    model=model,
#    args=training_args,
#    train_dataset=tokenized_dataset["train"],
#    eval_dataset=tokenized_dataset["test"],
#    tokenizer=tokenizer,
#    data_collator=data_collator,
#    compute_metrics=compute_metrics
# )

# trainer.train()

# last_checkpoint = "./results/checkpoint-45500"

# finetuned_model = T5ForConditionalGeneration.from_pretrained(last_checkpoint)
# tokenizer = T5Tokenizer.from_pretrained(last_checkpoint)

# my_question = "What do you think about the benefit of Artificial Intelligence?"
# inputs = "Please answer to this question: " + my_question

# inputs = tokenizer(inputs, return_tensors="pt")
# outputs = finetuned_model.generate(**inputs, do_sample=True, num_beams=1, penalty_alpha=0.6, top_k=4, max_new_tokens=512)
# answer = tokenizer.decode(outputs[0])
# from textwrap import fill

# print(fill(answer, width=80))

# input_text = "can you generate a test case for checking a value x is greater than 0?"
# input_ids = tokenizer(input_text, return_tensors="pt").input_ids

# outputs = model.generate(input_ids, do_sample=True, num_beams=1, penalty_alpha=0.6, top_k=4, max_new_tokens=512)
# print(tokenizer.decode(outputs[0]))