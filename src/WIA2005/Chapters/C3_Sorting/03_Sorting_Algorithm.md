# Chapter 3: Sorting Algorithms

```
WIA2005 Algorithm Design 
and Analysis
Lecture 3: Sorting Algorithm
Dr. Asmiza A. Sani
Semester 2, Session 2025/26
```

## Dataset 1

data1 = [1, 2, 3, 4, 6, 5, 7, 8, 9, 10]
Dataset 2
data2 = [100, 90, 80, 70, 60, 50, 40, 30, 20, 10]
Dataset 3
data3 = [5, 1, 5, 3, 5, 2, 1, 3, 5, 2]
Dataset 4:
data4 = [42, 7, 89, 3, 105, 64, 32, 19, 91, 58]
Example Dataset:

## Learning objectives

- The student will know the following algorithm:
- Bubble sort
- Counting sort
- Radix sort
- Bucket sort
- Shell sort

## Sorting Algorithms

- Sorting refers to the arranging of data in a particular format.
- Sorting algorithms contains a set of instruction to arrange data into
a particular order.
- Input data may be stored in an array or list.
- Common sort operation is performed in numerical or lexicographical
order.

## Why sorting?

Many computer scientists consider sorting to be the most fundamental
problem in the study of algorithms for the following reasons:
- Sometimes an application inherently needs to sort information.
- Optimised searching of data.
- Sorting allows data to be presented in a more readable format.

## Classification of Sorting Algorithm

- Before we investigate sorting algorithms, there are a few classifications
of sorting that we need to know:
- In-place vs. Not-In-Place Sorting
- Stable vs. Not Stable Sorting
- Adaptive vs. Non-Adaptive Sorting
- Online vs. Offline
- Other important terms related to sorting:
- Increasing order vs. Non- decreasing order
- Decreasing order vs. Non-increasing order

## In-place vs. Not-In-Place Sorting

- Some sorting algorithms may require additional space for comparing or
temporary storage of data.
- This is called not-in-place sorting.
- Merge sort is an example of a not-in-place sorting algorithm.
- The sorting algorithm that arranges without any additional storage (e.g.,
within the array itself) is called in-place sorting.
- Insertion sort is an example of an in-place sorting.

## Stable vs. Not Stable Sorting

- A stable sorting algorithm preserve the sequence of input after the sort has been
perform.
- If the sequence of input is not preserved after sorting, it is called the not-stable
sorting algorithm.
- Stability matters when we want to maintain the sequence of original input, such
as tuples.
6
5
2
3
1
3
1
2
3
3
5
6
6
5
2
3
1
3
1
2
3
3
5
6

## Adaptive vs. Non-Adaptive Sorting

- An adaptive sorting algorithm can take advantage of a pre-sorted input, while
non-adaptive ones do not.
- Usually, an adaptive algorithm is an improvement of an existing sorting
algorithm.
- Example of adaptive sorting: Insertion Sort

## Online vs. Offline

- An online sorting algorithm can process as the data is being fed and does not
require the whole input to be available initially.
- An example of an online algorithm is insertion sort.
- Conversely, an offline sorting algorithm needs all input to be available before
it can start processing the output.
- An example of an offline algorithm is the selection sort.

## Increasing order vs. Non- decreasing order

- Increasing order is any sequence where the element is greater than the
previous element.
- Non-decreasing order is any sequence where the element is greater than
or equal to the previous element.
1
2
3
3
5
6
1
2
3
4
5
6

## Decreasing order vs. Non-increasing order

- Decreasing order is any sequence where the element is smaller than
the previous element.
- Non-increasing order is any sequence where the element is smaller than
or equal to the previous element.
6
5
4
3
2
1
6
5
3
3
2
1

## How do you choose which sorting algorithm to

use?
- To choose the most appropriate sorting algorithm, you must know what the
input data is going to look like:
- The size of input?
- Nearly sorted/Random/Reversed/Duplicate?
- Best worst-case?
- Good average-case?
- The universe (range) of input?

## Sorting algorithms

## Algorithm

In-place?
Stable?
Adaptive?
Online?
Bubble sort
Counting sort
Radix Sort
Bucket sort
Shell sort
Classify the Sorting Algorithm

## Bubble sort

- Bubble sort is a popular but inefficient sorting algorithm. It works by
repeatedly swapping adjacent elements that are out of order.

## Bubble Sort Example

## Time complexity..

- What is the time complexity for Bubble sort?

## Time complexity..

- What is the time complexity for Bubble sort?
T(n) = Θ(n2)

## Counting sort

- The counting sort algorithm sorts elements based on numeric keys between a
specific range.
- No comparison is done during sorting.
- Used as a subroutine in another sorting algorithm.

## Counting-sort example

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
2
3
4

## Loop 1: initialization

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
0
0
0
0
1
2
3
4

## Loop 2: count

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
0
0
0
1
1
2
3
4

## Loop 2: count

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
0
0
1
1
2
3
4

## Loop 2: count

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
0
1
1
1
2
3
4

## Loop 2: count

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
0
1
2
1
2
3
4

## Loop 2: count

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
0
2
2
1
2
3
4

## Loop 3: compute running sum

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
0
2
2
1
2
3
4
C':
1
1
2
2

## Loop 3: compute running sum

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
0
2
2
1
2
3
4
C':
1
1
3
2

## Loop 3: compute running sum

A:
4
1
3
4
3
B:
1
2
3
4
5
C:
1
0
2
2
1
2
3
4
C':
1
1
3
5

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
3
1
2
3
4
5
C:
1
1
3
5
1
2
3
4
C':
1
1
3
5

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
3
1
2
3
4
5
C:
1
1
3
5
1
2
3
4
C':
1
1
2
5

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
3
4
1
2
3
4
5
C:
1
1
2
5
1
2
3
4
C':
1
1
2
5

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
3
4
1
2
3
4
5
C:
1
1
2
5
1
2
3
4
C':
1
1
2
4

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
3
3
4
1
2
3
4
5
C:
1
1
2
4
1
2
3
4
C':
1
1
2
4

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
3
3
4
1
2
3
4
5
C:
1
1
2
4
1
2
3
4
C':
1
1
1
4

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
1
3
3
4
1
2
3
4
5
C:
1
1
1
4
1
2
3
4
C':
1
1
1
4

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
1
3
3
4
1
2
3
4
5
C:
1
1
1
4
1
2
3
4
C':
0
1
1
4

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
1
3
3
4
4
1
2
3
4
5
C:
0
1
1
4
1
2
3
4
C':
0
1
1
4

## Loop 4: re-arrange

A:
4
1
3
4
3
B:
1
3
3
4
4
1
2
3
4
5
C:
0
1
1
4
1
2
3
4
C':
0
1
1
3

## Time complexity..

- What is the time complexity for Counting sort?

## Time complexity..

- What is the time complexity for Counting sort?
T(n) = Θ(𝑛+𝑘)

## Radix sort

- Radix sort is a non-comparative integer sorting algorithm that sorts data with
integer keys by grouping keys by the individual digits which share the same
significant position and value.
- It does this by using counting sort (but not limited to this – any stable sorting
method can be used to do this) to sort the n integers by digits, starting from
the least significant digit (i.e., one's digit for integers) to the most significant
digit.

## Radix sort

- Treat each digit as a key.
- Start from the least significant bit.
- Group the keys based on the digit while keeping the original order.
198099109123518183599
340199540380128115295
384700101594539614696
382408360201039258538
614386507628681328936
Most significant
Least significant

## Radix Sort Example (LSD)

- Original list (d = 3) :
- Sorting 1st least significant digit:
- Sorting 2nd least significant digit:
- Sorting 3rd least significant digit:
171
46
76
491
803
4
26
67
171
491
803
004
046
076
026
067
803
004
026
046
067
171
076
091
004
026
046
067
076
091
171
803
*Do not change the order!

## Time complexity..

- What is the time complexity for Radix sort?

## Time complexity..

- What is the time complexity for Radix sort?
T(n) = Θ (d(n+k))

## Bucket sort

- Bucket sort algorithm creates buckets and put elements into them.
- Then using some sorting algorithm (e.g., Insertion sort) to sort elements
in each bucket.
- Then the elements are taken out and joined to get the sorted result.

## Bucket sort

- Assumption: uniform distribution
- Input numbers are uniformly distributed in [0,1).
- Suppose the input size is n.
- Idea:
- Divide [0,1) into n equal-sized subintervals (buckets).
- Distribute n numbers into buckets
- Expect that each bucket contains a few numbers.
- Sort numbers in each bucket (insertion sort as default).
- Then, go through buckets in order, listing elements.

## Bucket Sort Example

- Sort:
28
24
4
48
8
36
22
43
Bucket (0-9)
4, 8
Bucket (10-19)
Bucket (20-29)
28, 24,
22
Bucket (30-39)
36
Bucket (40-49)
48, 43
Step 1: Insert data in
bucket accordingly.
Bucket (0-9)
4, 8
Bucket (10-19)
Bucket (20-29)
22, 24,
28
Bucket (30-39)
36
Bucket (40-49)
43, 48
Step 2: Sort data in
bucket.
Step 3: Merge data
in all bucket
sequentially.
4
8
22
24
28
36
43
48

## Example of BUCKET-SORT

## Time complexity..

- What is the time complexity of Bucket sort?

## Time complexity..

- What is the time complexity of Bucket sort?
T(n) = Θ(𝑛)

## Shell sort

- A generalisation of the Insertion sort
- sorting by comparing elements that
are distant apart rather than
adjacent.
- If we start comparing N elements that
are at a certain distance apart
- value gap < N.
- The value of the gap is reduced in each
pass until the last pass, where gap = 1.
- In the last pass, the sort is like an
insertion sort.

## Shell Sort Example

Sort:
8 Numbers to be sorted, Shell’s increment will be floor(n/2)
Step 1: When gap floor(8/2) = 4
18
32
12
5
38
33
16
2
1
2
3
4
1
2
3
4
18
32
12
5
38
33
16
2
18
32
12
2
38
33
16
5
* Do insertion sort operation with all elements with the same colour

## Shell Sort Example

Step 2: When gap floor(4/2) = 2
1
2
1
2
1
2
1
2
18
32
12
2
38
33
16
5
12
2
16
5
18
32
38
33
* Do insertion sort operation with all elements with the same colour

## Shell Sort Example

Step 3: When gap floor(2/2) = 1
1
1
1
1
1
1
1
1
12
2
16
5
18
32
38
33
2
5
12
16
18
32
33
38
* Do insertion sort operation with all elements with the same colour

## Time complexity..

- What is the time complexity of Shell sort?

## Time complexity..

- What is the time complexity of Shell sort?
Several variants, ranging from slightly worse than Θ(𝑛log 𝑛)
to Θ(𝑛2) – Depending on the gap sequence.

## Time complexity..

Wikipedia

## Algorithm

In-place?
Stable?
Adaptive?
Online?
Bubble sort
Counting sort
Radix Sort
Bucket sort
Shell sort
Classify the Sorting Algorithm

## Dataset 1: Nearly Sorted Data

data1 = [1, 2, 3, 4, 6, 5, 7, 8, 9, 10]
Nature:
- Almost completely sorted except for a small
inversion (6 and 5).
- Best suited for: Insertion Sort,
- Reason: These algorithms are optimized for
data that is already or nearly sorted.
Dataset 2: Reverse Sorted Data
data2 = [100, 90, 80, 70, 60, 50, 40, 30, 20, 10]
Nature:
- Completely reverse ordered.
- Best suited for: Merge Sort or Heap Sort
- Reason: Quick Sort with poor pivot selection
will degrade to O(n²); Insertion Sort also
performs poorly.
Dataset 3: Data with Many Duplicates
data3 = [5, 1, 5, 3, 5, 2, 1, 3, 5, 2]
Nature:
- Contains many repeated values.
- Best suited for: Counting Sort or Stable
Sorts (e.g., Merge Sort)
- Reason: Counting Sort handles duplicates
efficiently when the range is small.
Dataset 4: Random Unsorted Data (Large
Range)
data4 = [42, 7, 89, 3, 105, 64, 32, 19, 91, 58]
Nature:
- Random integers within a wide range.
- Best suited for: Quick Sort, Merge Sort
- Reason: Standard comparison-based sorts
work well when data is unpredictable and
values are not constrained.

## In the next lecture..

Lecture 4: String Matching Algorithm

## References

- Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford
Stein. 2009. Introduction to Algorithms, 3rd edition. MIT Press.
- Robert Sedgewick and Kevin Wayne. 2011. Algorithm. 5th Edition.
Addison- Wesley.
