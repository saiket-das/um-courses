# Chapter 5: Divide and Conquer Algorithms

```
WIA2005: Algorithm Design 
and Analysis
Lecture 5: Divide & Conquer Algorithm
Asmiza A. Sani 
Semester 2, Session 2025/26
```

## Learning objectives

- The student will know and understand the following:
- Algorithm design paradigm: Divide and Conquer
- Merge sort
- Quick sort

## Algorithm Design Paradigm

- When we are designing an algorithm, there are several high-level approach that
can be taken to solve a certain class of problems.
- Common ones are:
- Divide and conquer
- Recursively breaking down a problem into 2 or more sub-problems of the same type.
- No overlapping sub-problem.
- Dynamic programming
- Breaking down a problem into a collection of simpler problem.
- Sub-problem must overlap.
- Greedy algorithms
- Making a locally optimal decision at each stage.
- Others:
- Brute force
- Backtracking

## The Divide and Conquer Design Paradigm

- The Divide and Conquer algorithm apply the concept of dividing problems
into smaller sub-problem.
- The approach:
1.Divide the problem (instance) into subproblems.
2.Conquer the subproblems by solving them recursively.
3.Combine subproblem solutions.

## Merge Sort Algorithm

- Merge sort is a sorting algorithm that follows the divide and conquer
approach.
- The approach:
1.Divide: Trivial.
2.Conquer: Recursively sort 2 subarrays.
3.Combine: Linear-time merge.

## Merge Sort Algorithm

## Merge operation

## Merge operation Cont..

## Merge Sort operation

## Running Time Complexity – Merge Sort

1.Divide: Trivial.
2.Conquer: Recursively sort 2 subarrays.
3.Combine: Linear-time merge.
- Recurrence relation:
T(n) = 2 T(n/2) + (n)
# subproblems
subproblem size
work dividing
and combining
What is running time
complexity of Merge
Sort?

## Running Time Complexity

1.Divide: Trivial.
2.Conquer: Recursively sort 2 subarrays.
3.Combine: Linear-time merge.
T(n) = 2 T(n/2) +(n)
# subproblems
subproblem size
work dividing
and combining
Using Master
Theorem
T(n) = (n log n)

## Quicksort Algorithm

- Approach (Quicksort an n-element array):
1.Divide: Partition the array into two subarrays around a pivot x such that elements in
lower subarray ≤x ≤elements in upper subarray.
2.Conquer: Recursively sort the two subarrays.
3.Combine: Trivial.
- Key: Linear-time partitioning subroutine.

## Quicksort Algorithm

## Quicksort Algorithm

- 
Array entry A[r] becomes the pivot element x.
- 
Lightly shaded array elements are all in the
first partition with values no greater than x.
- 
Heavily shaded elements are in the second
partition with values greater than x.
- 
The unshaded elements have not yet been
put in one of the first two partitions, and the
final white element is the pivot x.
The initial array and variable settings. None of
the elements have been placed in either of the
first two partitions.
The value 2 is “swapped with itself” and put in
the partition of smaller values
The values 8 and 7 are added to the partition of
larger values.
The values 1 and 8 are swapped, and the
smaller partition grows.
The values 3 and 7 are swapped, and the
smaller partition grows.
The larger partition grows to include 5 and 6,
and the loop terminates.
In lines 7–8, the pivot element is swapped so
that it lies between the two partitions.

## Running Time Complexity

- Assume all input elements are distinct (else use the 3-way quicksort).
- In practice, there are better partitioning algorithms for when duplicate input
elements may exist.
When will the worst-case behaviour
happen in Quicksort?
Running time: T(n) = T(k) + T(n-k-1) + (n)
Running time depends
on the input array and
the partition strategy.

## Worst Case of Quicksort

- Input sorted or reverse sorted.
- Partition around min or max element.
- One side of partition always has no elements.
- Using back-substitution method:
T(n) = T(0) +T(n −1) + (n)
= (1)+T(n −1) + (n)
= T(n −1) + (n)
= (n2)
(arithmetic series)

## T(n) = T(0) + T(n–1) + cn

T(0)
cn
c(n–1)
T(0)
c(n–2)
T(0)
(1)
…
𝑘=1
∑𝑛
𝑘= (𝑛)
How will the Recursion Tree of
Quicksort look like?

## Best-case analysis

- To see how Quicksort can ensure (n log n) running time on any input, we need to
understand what is the partition condition that guarantee this.
- If we’re lucky, PARTITION splits the array evenly:
T(n)
= 2T(n/2) + (n)
= (n log n)
10
10
- But what if the split is always
1 : 9
Are we still going to get (n log n)
running time? Or we are reaching (n2)?
T(n) = T( 1 n)+T( 9 n)+ (n)
10
10
(same as merge sort)
What is the solution
to this recurrence?

## log10n

cn
10
1cn
10
9cn
100
1 cn
100
9 cn
100
9 cn
100
10/9
log
n
cn
cn
81cn
cn
(1)
cnlog10n T(n) cnlog10/9n + (n)
(1)
(nlogn)
Good!
…
O(n) leaves
How will the Recursion Tree of Quicksort with
1 : 9
10
10 partition look like?

## More Intuition

- Here, we can further see, how Quicksort can still perform in (n log n).
- Suppose we have alternate Good, Not Good,…. partition each time:
G(n)
N(n)
= 2N(n/2) + (n)
= G(n–1) + (n)
- Solving:
G(n)
Good
Not Good
= 2(G(n/2 – 1) + (n/2)) + (n)
= 2G(n/2 – 1) + (n)
= (n log n)
Good!
How can we make
sure we are usually
having a good
partition?

## Randomized Quicksort

- To make sure that Quicksort will always have a lucky O(n log n) running time:
- IDEA: Partition around a random element.
- Running time is independent of the input order.
- No assumptions need to be made about the input distribution.
- No specific input elicits the worst-case behaviour.
- The worst case is determined only by the output of a random-number generator.
What is the
classification of
Quicksort?

## Additional common problem

solve using divide and
conquer approach

## Binary Search Algorithm

- Find an element in a sorted array:
1. Divide: Check middle element.
2. Conquer: Recursively search 1 subarray.
3. Combine: Trivial.

## Binary search

- Find an element in a sorted array:
1. Divide: Check middle element.
2. Conquer: Recursively search 1 subarray.
3. Combine: Trivial.
- Example: Find 9 in the following array A
3
5
7
8
9
12
15

## Binary search

- Find an element in a sorted array:
1. Divide: Check middle element.
2. Conquer: Recursively search 1 subarray.
3. Combine: Trivial.
- Example: Find 9 in the following array A
3
5
7
8
9
12
15
Check the middle element in the array
and compare with the key.

## Binary search

- Find an element in a sorted array:
1. Divide: Check middle element.
2. Conquer: Recursively search 1 subarray.
3. Combine: Trivial.
- Example: Find 9 in the following array A
3
5
7
8
9
12
15
In this case, key is bigger than the
middle element. Therefore, we can
eliminate the lower subarray and repeat
Step 1, which is check the middle
element.

## Binary search

- Find an element in a sorted array:
1. Divide: Check middle element.
2. Conquer: Recursively search 1 subarray.
3. Combine: Trivial.
- Example: Find 9 in the following array A
3
5
7
8
9
12
15
Check the middle element in the
subarray and compare with the key.

## Binary search

- Find an element in a sorted array:
1. Divide: Check middle element.
2. Conquer: Recursively search 1 subarray.
3. Combine: Trivial.
- Example: Find 9 in the following array A
3
5
7
8
9
12
15
In this case, key is smaller than the
middle element. Therefore, we can
eliminate the higher subarray and
repeat Step 1, which is check the
middle element.

## Binary search

- Find an element in a sorted array:
1. Divide: Check middle element.
2. Conquer: Recursively search 1 subarray.
3. Combine: Trivial.
- Example: Find 9 in the following array A
3
5
7
8
9
12
15
Found 9 in the array!

## T(n) = 1 T(n/2) +(1)

# subproblems
subproblem size
work dividing
and combining
Running time complexity
Using Masters Theorem
T(n) = Θ(lg n)

## Powering a number

Problem: Compute an, where n N.
Naive algorithm: (n).

## Powering a number

an =
a n/2a n/2
a (n–1)/2a (n–1)/2a
if n is even;
if n is odd.
Problem: Compute an, where n 
N.
Naive algorithm: (n).
Divide-and-conquer algorithm:
T(n) = T(n/2) + (1) T(n) = (lg n).

## Fibonacci numbers

Recursive definition:
Fn=
1
if n = 0;
2
if n = 1;
Fn–1 + Fn–2
if n 2.
0
1
1
2
3
5
8 13 21 34 L

## Computing Fibonacci numbers

Bottom-up:
- Compute F0, F1, F2, …, Fn in order, forming
each number by summing the two previous.
- Running time: (n).
Naive recursive squaring:
Fn = n/
5 rounded to the nearest integer.
- Recursive squaring: (lg n) time.
- This method is unreliable, since floating-
point arithmetic is prone to round-off
errors.

## Recursive squaring

## Recursive squaring

## Matrix Multiplication

Suppose that we partition each of A, B, and C into four n/2 x n/2 matrices
so that we rewrite the equation C = A.B as
Equation (4.10) corresponds to the four equations

## Matrices simple algorithm

## Running time

From master methods:

## Reference

- MIT open courseware, Introduction to Algorithms, 2005.
- Cormen, Lieserson and Rivest, Introduction to Algorithms, Third Edition, MIT
Press, 2009.

## We are also going to look at

Heapsort today.
