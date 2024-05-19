# from transformers import pipeline

# classifier = pipeline("sentiment-analysis")

# classifier("We are very happy to show you the 🤗 Transformers library.")

# results = classifier(["We are very happy to show you the 🤗 Transformers library.", "We hope you don't hate it."])
# for result in results:
#     print(f"label: {result['label']}, with score: {round(result['score'], 4)}")

from transformers import RagConfig, RagTokenizer, RagRetriever, RagTokenForGeneration

config = RagConfig.from_pretrained("facebook/rag-token-nq")
tokenizer = RagTokenizer.from_pretrained("facebook/rag-token-nq")
retriever = RagRetriever.from_pretrained("facebook/rag-token-nq", index_name="exact", use_dummy_dataset=True)
model = RagTokenForGeneration.from_pretrained("facebook/rag-token-nq", retriever=retriever)

input_dict = tokenizer.prepare_seq2seq_batch("can you generate a test case for checking a value x is greater than 0?", return_tensors="pt")
generated = model.generate(input_dict["input_ids"], do_sample=True, num_beams=1, penalty_alpha=0.6, top_k=4, max_new_tokens=512)
print(tokenizer.batch_decode(generated, skip_special_tokens=True)[0])
