This is my attempt at generating JUnit tests using LLMs based on given methods or prompts.

The folders at the top contain the generated tests using the __t5-train.py__ code that fine tunes the __t5-small__ model on __jitx/Methods2Test_java_unit_test_code__ dataset.
The dataset has methods as inputs and JUnit tests as outputs. I have attempted to use only the main method that needs to be tested, and the results are in _java_test_results_ and _java_test_results_bigger_dataset_, 
but I have also tested the results when giving it more than just the method, so that it can have more context, and the results are in _java_test_results_src_fm_fc_ms_ff_.

The results are not compilable. There was an aim at slightly modifying them so that they may compile and I would be able to test the coverage and the correctness of the tests, but the generated tests are too far
from a compilable version. The task needed too much work and the result wouldn't even be comparable with the initial generated test.

The biggest reason why the results are not great is the model used and its limitations. It is a small model because a bigger one would require more resources, not local ones, as I have used. The model has limitations regarding the input and output lengths, and thus the capacity to understand complex patterns.

The next step would be to use a bigger model with resources in cloud and compare the results.

BONUS:
The rest of the files are other ways in which I approached the task. I used different models, like __gpt2__, but __t5-small__ gave better results because it is a sequence-to-sequence model. I also used the java
tests from __HumanEval-XL__ that had a prompt as input (a description of the functionality of the method that should be tested), and the JUnit tests as output, but the results were not great, partly because there is
a lot less data (<100 samples) than in the __Methods2Test_java_unit_test_code__ (>60000, of which I have used 6000), but also because the task was different (generating test from method vs generating test from prompt).
