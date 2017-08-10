# WorkingWithThreadsInJava

To demostrate the use of threads we will sum 1 million elements using a divide and conquer strategy:
- Create an array of 1 million random elements.
- Use a thread for every 250000 elements ( Number of Threads = Size / 250000).
- Wait for all the threads to finish.
- Make the final Sum using the sums calculated by each thread.