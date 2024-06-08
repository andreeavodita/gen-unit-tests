from datasets import load_metric
from transformers import AutoModelForCausalLM, AutoTokenizer, TrainingArguments, BitsAndBytesConfig

def evaluate():
    # Load the trained model and tokenizer
    model_name = "gpt2-tuned"
    tokenizer = AutoTokenizer.from_pretrained(model_name)
    model = AutoModelForCausalLM.from_pretrained(model_name)

    # Set the model to evaluation mode
    model.eval()

    # Prepare test inputs and expected outputs
    test_cases = [
        {"input": "Below is a prompt with the initial code snippet provided as the context for the task, paired with the entry point that shows what the main method that need to be implemented is and a description of the task requirements. Write test cases to validate the implementation of the task. ### Prompt: import java.io.*;\nimport java.lang.*;\nimport java.util.*;\nimport java.math.*;\n\n\nclass IsPrime {\n    /**\n     * Return true if a given number is prime, and false otherwise.\n     * >>> is_prime(6)\n     * False\n     * >>> is_prime(101)\n     * True\n     * >>> is_prime(11)\n     * True\n     * >>> is_prime(13441)\n     * True\n     * >>> is_prime(61)\n     * True\n     * >>> is_prime(4)\n     * False\n     * >>> is_prime(1)\n     * False\n     *\n     */\n    public static Boolean isPrime(int n) {\n ### Entry Point: isPrime ### Description: Return true if a given number is prime, and false otherwise.\n    >>> is_prime(6)\n    False\n    >>> is_prime(101)\n    True\n    >>> is_prime(11)\n    True\n    >>> is_prime(13441)\n    True\n    >>> is_prime(61)\n    True\n    >>> is_prime(4)\n    False\n    >>> is_prime(1)\n    False", "expected_output": "\n\nclass Main {\n    public static boolean compare(Object obj1, Object obj2) {\n        if (obj1 == null && obj2 == null){\n            return true;\n        } else if (obj1 == null || obj2 == null){\n            return false;\n        } else {\n            return obj1.equals(obj2);\n        }\n    }\n    \n    public static void main(String[] args) throws Exception {\n        int arg00 = 6;\n        Boolean x0 = IsPrime.isPrime(6);\n        Boolean v0 = false;\n        if (!(compare(x0, v0))) {\n            throw new java.lang.Exception(\"Exception -- test case 0 did not pass. x0 = \" + x0);\n        }\n\n        int arg10 = 101;\n        Boolean x1 = IsPrime.isPrime(101);\n        Boolean v1 = true;\n        if (!(compare(x1, v1))) {\n            throw new java.lang.Exception(\"Exception -- test case 1 did not pass. x1 = \" + x1);\n        }\n\n        int arg20 = 11;\n        Boolean x2 = IsPrime.isPrime(11);\n        Boolean v2 = true;\n        if (!(compare(x2, v2))) {\n            throw new java.lang.Exception(\"Exception -- test case 2 did not pass. x2 = \" + x2);\n        }\n\n        int arg30 = 13441;\n        Boolean x3 = IsPrime.isPrime(13441);\n        Boolean v3 = true;\n        if (!(compare(x3, v3))) {\n            throw new java.lang.Exception(\"Exception -- test case 3 did not pass. x3 = \" + x3);\n        }\n\n        int arg40 = 61;\n        Boolean x4 = IsPrime.isPrime(61);\n        Boolean v4 = true;\n        if (!(compare(x4, v4))) {\n            throw new java.lang.Exception(\"Exception -- test case 4 did not pass. x4 = \" + x4);\n        }\n\n        int arg50 = 4;\n        Boolean x5 = IsPrime.isPrime(4);\n        Boolean v5 = false;\n        if (!(compare(x5, v5))) {\n            throw new java.lang.Exception(\"Exception -- test case 5 did not pass. x5 = \" + x5);\n        }\n\n        int arg60 = 1;\n        Boolean x6 = IsPrime.isPrime(1);\n        Boolean v6 = false;\n        if (!(compare(x6, v6))) {\n            throw new java.lang.Exception(\"Exception -- test case 6 did not pass. x6 = \" + x6);\n        }\n\n        int arg70 = 5;\n        Boolean x7 = IsPrime.isPrime(5);\n        Boolean v7 = true;\n        if (!(compare(x7, v7))) {\n            throw new java.lang.Exception(\"Exception -- test case 7 did not pass. x7 = \" + x7);\n        }\n\n        int arg80 = 11;\n        Boolean x8 = IsPrime.isPrime(11);\n        Boolean v8 = true;\n        if (!(compare(x8, v8))) {\n            throw new java.lang.Exception(\"Exception -- test case 8 did not pass. x8 = \" + x8);\n        }\n\n        int arg90 = 17;\n        Boolean x9 = IsPrime.isPrime(17);\n        Boolean v9 = true;\n        if (!(compare(x9, v9))) {\n            throw new java.lang.Exception(\"Exception -- test case 9 did not pass. x9 = \" + x9);\n        }\n\n        int arg100 = 85;\n        Boolean x10 = IsPrime.isPrime(85);\n        Boolean v10 = false;\n        if (!(compare(x10, v10))) {\n            throw new java.lang.Exception(\"Exception -- test case 10 did not pass. x10 = \" + x10);\n        }\n\n        int arg110 = 77;\n        Boolean x11 = IsPrime.isPrime(77);\n        Boolean v11 = false;\n        if (!(compare(x11, v11))) {\n            throw new java.lang.Exception(\"Exception -- test case 11 did not pass. x11 = \" + x11);\n        }\n\n        int arg120 = 255379;\n        Boolean x12 = IsPrime.isPrime(255379);\n        Boolean v12 = false;\n        if (!(compare(x12, v12))) {\n            throw new java.lang.Exception(\"Exception -- test case 12 did not pass. x12 = \" + x12);\n        }\n\n\n}\n}\n\n"},
        # {"input": "Below is a prompt with the initial code snippet provided as the context for the task, paired with the entry point that shows what the main method that need to be implemented is and a description of the task requirements. Write test cases to validate the implementation of the task. ### Prompt: import java.io.*;\nimport java.lang.*;\nimport java.util.*;\nimport java.math.*;\n\n\nclass GreatestCommonDivisor {\n    /**\n     * Return a greatest common divisor of two integers a and b\n     * >>> greatest_common_divisor(3, 5)\n     * 1\n     * >>> greatest_common_divisor(25, 15)\n     * 5\n     *\n     */\n    public static int greatestCommonDivisor(int a, int b) {\n ### Entry Point: greatestCommonDivisor ### Description: Return a greatest common divisor of two integers a and b\n    >>> greatest_common_divisor(3, 5)\n    1\n    >>> greatest_common_divisor(25, 15)\n    5", "expected_output": "\n\nclass Main {\n    public static boolean compare(Object obj1, Object obj2) {\n        if (obj1 == null && obj2 == null){\n            return true;\n        } else if (obj1 == null || obj2 == null){\n            return false;\n        } else {\n            return obj1.equals(obj2);\n        }\n    }\n    \n    public static void main(String[] args) throws Exception {\n        int arg00 = 3;\n        int arg01 = 7;\n        int x0 = GreatestCommonDivisor.greatestCommonDivisor(3, 7);\n        int v0 = 1;\n        if (!(compare(x0, v0))) {\n            throw new java.lang.Exception(\"Exception -- test case 0 did not pass. x0 = \" + x0);\n        }\n\n        int arg10 = 10;\n        int arg11 = 15;\n        int x1 = GreatestCommonDivisor.greatestCommonDivisor(10, 15);\n        int v1 = 5;\n        if (!(compare(x1, v1))) {\n            throw new java.lang.Exception(\"Exception -- test case 1 did not pass. x1 = \" + x1);\n        }\n\n        int arg20 = 49;\n        int arg21 = 14;\n        int x2 = GreatestCommonDivisor.greatestCommonDivisor(49, 14);\n        int v2 = 7;\n        if (!(compare(x2, v2))) {\n            throw new java.lang.Exception(\"Exception -- test case 2 did not pass. x2 = \" + x2);\n        }\n\n        int arg30 = 144;\n        int arg31 = 60;\n        int x3 = GreatestCommonDivisor.greatestCommonDivisor(144, 60);\n        int v3 = 12;\n        if (!(compare(x3, v3))) {\n            throw new java.lang.Exception(\"Exception -- test case 3 did not pass. x3 = \" + x3);\n        }\n\n\n}\n}\n\n"},
        # {"input": "Below is a prompt with the initial code snippet provided as the context for the task, paired with the entry point that shows what the main method that need to be implemented is and a description of the task requirements. Write test cases to validate the implementation of the task. ### Prompt: import java.io.*;\nimport java.lang.*;\nimport java.util.*;\nimport java.math.*;\n\n\nclass SameChars {\n    /**\n     * * Check if two words have the same characters.\n     * >>> same_chars('eabcdzzzz', 'dddzzzzzzzddeddabc')\n     * True\n     * >>> same_chars('abcd', 'dddddddabc')\n     * True\n     * >>> same_chars('dddddddabc', 'abcd')\n     * True\n     * >>> same_chars('eabcd', 'dddddddabc')\n     * False\n     * >>> same_chars('abcd', 'dddddddabce')\n     * False\n     * >>> same_chars('eabcdzzzz', 'dddzzzzzzzddddabc')\n     * False\n     *\n     */\n    public static Boolean sameChars(String s0, String s1) {\n ### Entry Point: sameChars ### Description: Check if two words have the same characters.\n    >>> same_chars('eabcdzzzz', 'dddzzzzzzzddeddabc')\n    True\n    >>> same_chars('abcd', 'dddddddabc')\n    True\n    >>> same_chars('dddddddabc', 'abcd')\n    True\n    >>> same_chars('eabcd', 'dddddddabc')\n    False\n    >>> same_chars('abcd', 'dddddddabce')\n    False\n    >>> same_chars('eabcdzzzz', 'dddzzzzzzzddddabc')\n    False", "expected_output": "\n\nclass Main {\n    public static boolean compare(Object obj1, Object obj2) {\n        if (obj1 == null && obj2 == null){\n            return true;\n        } else if (obj1 == null || obj2 == null){\n            return false;\n        } else {\n            return obj1.equals(obj2);\n        }\n    }\n    \n    public static void main(String[] args) throws Exception {\n        String arg00 = \"eabcdzzzz\";\n        String arg01 = \"dddzzzzzzzddeddabc\";\n        Boolean x0 = SameChars.sameChars(\"eabcdzzzz\", \"dddzzzzzzzddeddabc\");\n        Boolean v0 = true;\n        if (!(compare(x0, v0))) {\n            throw new java.lang.Exception(\"Exception -- test case 0 did not pass. x0 = \" + x0);\n        }\n\n        String arg10 = \"abcd\";\n        String arg11 = \"dddddddabc\";\n        Boolean x1 = SameChars.sameChars(\"abcd\", \"dddddddabc\");\n        Boolean v1 = true;\n        if (!(compare(x1, v1))) {\n            throw new java.lang.Exception(\"Exception -- test case 1 did not pass. x1 = \" + x1);\n        }\n\n        String arg20 = \"dddddddabc\";\n        String arg21 = \"abcd\";\n        Boolean x2 = SameChars.sameChars(\"dddddddabc\", \"abcd\");\n        Boolean v2 = true;\n        if (!(compare(x2, v2))) {\n            throw new java.lang.Exception(\"Exception -- test case 2 did not pass. x2 = \" + x2);\n        }\n\n        String arg30 = \"eabcd\";\n        String arg31 = \"dddddddabc\";\n        Boolean x3 = SameChars.sameChars(\"eabcd\", \"dddddddabc\");\n        Boolean v3 = false;\n        if (!(compare(x3, v3))) {\n            throw new java.lang.Exception(\"Exception -- test case 3 did not pass. x3 = \" + x3);\n        }\n\n        String arg40 = \"abcd\";\n        String arg41 = \"dddddddabcf\";\n        Boolean x4 = SameChars.sameChars(\"abcd\", \"dddddddabcf\");\n        Boolean v4 = false;\n        if (!(compare(x4, v4))) {\n            throw new java.lang.Exception(\"Exception -- test case 4 did not pass. x4 = \" + x4);\n        }\n\n        String arg50 = \"eabcdzzzz\";\n        String arg51 = \"dddzzzzzzzddddabc\";\n        Boolean x5 = SameChars.sameChars(\"eabcdzzzz\", \"dddzzzzzzzddddabc\");\n        Boolean v5 = false;\n        if (!(compare(x5, v5))) {\n            throw new java.lang.Exception(\"Exception -- test case 5 did not pass. x5 = \" + x5);\n        }\n\n        String arg60 = \"aabb\";\n        String arg61 = \"aaccc\";\n        Boolean x6 = SameChars.sameChars(\"aabb\", \"aaccc\");\n        Boolean v6 = false;\n        if (!(compare(x6, v6))) {\n            throw new java.lang.Exception(\"Exception -- test case 6 did not pass. x6 = \" + x6);\n        }\n\n\n}\n}\n\n"}
    ]

    # Initialize a metric (e.g., BLEU, ROUGE)
    metric = load_metric("bleu")

    for case in test_cases:
        inputs = tokenizer(case["input"], return_tensors="pt")
        outputs = model.generate(inputs.input_ids, max_length=1024, num_return_sequences=1)

        # Decode the generated output
        generated_text = tokenizer.decode(outputs[0], skip_special_tokens=True)

        print(f"Generated Output: {generated_text}\n")

        # Compute the metric
        metric.add(prediction=generated_text, reference=case["expected_output"])

    # Compute and print the final metric
    final_score = metric.compute()
    print(f"Evaluation Score: {final_score}")

if __name__ == "__main__":
    evaluate()
