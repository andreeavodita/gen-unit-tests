import torch
from transformers import GPT2LMHeadModel, GPT2Tokenizer

def generate_text(model, tokenizer, prompt, max_length=512, max_new_tokens=50):
    input_ids = tokenizer.encode(prompt, return_tensors='pt').to('cuda')

    # Generate text
    output = model.generate(input_ids, max_length=max_length, num_return_sequences=1)

    # Decode and return the generated text
    return tokenizer.decode(output[0], skip_special_tokens=True)

def main():
    # Load trained model and tokenizer
    model_name = './my-gpt2'  # Path to your trained model
    tokenizer = GPT2Tokenizer.from_pretrained(model_name)
    model = GPT2LMHeadModel.from_pretrained(model_name)

    # Set the device to GPU if available
    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    model.to(device)

    # Example prompt
    prompt = "prime_fib returns n-th number that is a Fibonacci number and it's also prime.\n    >>> prime_fib(1)\n    2\n    >>> prime_fib(2)\n    3\n    >>> prime_fib(3)\n    5\n    >>> prime_fib(4)\n    13\n    >>> prime_fib(5)\n    89"

    # Generate text based on the prompt
    generated_text = generate_text(model, tokenizer, prompt)

    # Print the generated text
    print("Generated Text:")
    print(generated_text)

if __name__ == "__main__":
    main()
