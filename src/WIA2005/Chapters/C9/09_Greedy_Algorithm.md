# Chapter 9: Greedy Algorithms

```
Strategy?
```

## Strategy:

1. Buy the cheapest bags first.
2. Buy the most expensive bags first.
3. Buy bags until RM100 is fully
used.
4. Maximise number of bags.
5. Maximise “value”, if each bag has
usefulness scores.

## WIA2005: Algorithm Design

and Analysis
Lecture 9: Greedy Algorithm
Asmiza A. Sani
Semester 2, Session 2025/26

## Learning Objectives

- Greedy Algorithm
- Huffman
- Job sequencing

## Algorithm Design Paradigm (Recap)

- When we are designing an algorithm, there are several high-level approach
that can be taken to solve a certain class of problems.
- Common ones are:
- Divide and conquer
- Recursively breaking down a problem into 2 or more sub-problems of the same type.
- No overlapping sub-problem.
- Dynamic programming
- Breaking down a problem into a collection of simpler problem.
- Sub-problem must overlap.
- Greedy algorithms
- Making a locally optimal decision at each stage.

## Introduction

- A greedy algorithm always makes the choice that looks best at the moment.
That is, it makes a locally optimal choice in the hope that this choice will lead
to a globally optimal solution.
- For many optimisation problems, simpler algorithms like the greedy algorithm
suffice rather than the overkill of dynamic programming.

## How can we tell whether a greedy algorithm will solve a particular

optimization problem?
- There are two properties that qualifies for a greedy solution:
1.
Greedy-choice property
2.
Optimal substructure
- If we can demonstrate that the problem has these properties, then we are well
on the way to developing a greedy algorithm for it.

## Elements of the greedy strategy

- A greedy algorithm obtains an optimal solution to a problem by making a
sequence of choices. At each decision point, the algorithm makes choice that
seems best at the moment.
1. Determine the optimal substructure of the problem.
2. Develop a recursive solution.
3. Show that if we make the greedy choice, then only one sub problem remains.
4. Prove that it is always safe to make the greedy choice. (Steps 3 and 4 can
occur in either order.)
5. Develop a recursive algorithm that implements the greedy strategy.
6. Convert the recursive algorithm to an iterative algorithm.

## Where Greedy Algorithm fails (0-1 Knapsack Problem)

- Greedy algorithms do not always yield optimal solutions.

## Where Dynamic Programming provides better solutions

(Fractional Knapsack Problem)
- Same items, same capacity, but now fractions are allowed.
Greedy by value/weight ratio
$60/10
= $6
$100/20
= $5
$120/30
= $4

## Let’s compare..

- What is the greedy choice in the fractional knapsack?
- Why does the same rule fail for the 0-1 knapsack?
- What does “safe choice” mean?

## An activity-selection problem

- This is a scheduling problem involving several competing activities that require exclusive use of a common resource,
with the goal of selecting a maximum-size set of mutually compatible activities.
- Suppose there is a set S = {a1, a2, ..., an} of n proposed activities, each seeking to use a resource that can serve
only one activity at a time.
- Each activity ai has a start time si and a finish time fi , where 0 < si < fi < ∞.
- It is assumed that the activities are arranged in monotonically increasing order of their finish times.
i
1
2
3
4
5
6
7
8
9
10
11
si
1
3
0
5
3
5
6
8
8
2
12
f i
4
5
6
7
9
9
10
11
12
14
16
Greedy strategy:
Choose an earlier start time first?
Choose a shorter duration first?
Choose the earliest finish time first?
Which strategy works?

## Example

- If we choose earliest start time first - the subset {a3, a9, a11} consists of mutually compatible
activities.
- 
It is not a maximum subset,
- If we choose the earliest finish time first, the subset {a1, a4, a8, a11} contains more activities.
- 
Another largest subset is {a2, a4, a9, a11}
i
1
2
3
4
5
6
7
8
9
10
11
si
1
3
0
5
3
5
6
8
8
2
12
f i
4
5
6
7
9
9
10
11
12
14
16

## An iterative greedy algorithm

- GREEDY-ACTIVITY-SELECTOR schedules a set of n activities
in O(n) time, assuming that the activities were already sorted
initially by their finish times.

## Huffman code

- Huffman codes compress data very effectively: savings of 20% to 90% are
typical, depending on the characteristics of the data being compressed.
- We consider the data to be a sequence of characters. Huffman’s greedy
algorithm uses a table giving how often each character occurs (i.e., its
frequency) to build up an optimal way of representing each character as a
binary string.

## Example

- Suppose there is a 100,000-character data file that we wish to store
compactly.
- The characters in the file occur at the frequencies shown in the figure below.
a
b
c
d
e
f
Frequency (in thousands)
45
13
12
16
9
5
Fixed-length codeword
000
001
010
011
100
101
If we assign each of the 100,000 characters a 3-bit codeword, we can encode the file in 300,000 bits.

## Variable-Length Codeword

- In variable-length coding, different characters can use different numbers of bits.
- The greedy idea in Huffman coding is:
Characters that appear more frequently should get shorter codewords, while
less frequent characters should get longer codewords.
a
b
c
d
e
f
Frequency (in thousands)
45
13
12
16
9
5
Fixed-length codeword
000
001
010
011
100
101
Variable-length codeword
0
101
100
111
1101
1100
The total number of bits becomes:
(45×1 + 13×3 + 12×3 + 16×3 + 9×4 + 5×4) × 1000 = 224,000 bits
So, compared to fixed-length coding:
300,000 bits − 224,000 bits = 76,000 bits saved (25.33%)

## Huffman Tree

## Constructing a Huffman code

- The total running time of HUFFMAN on a set of n characters
is O(n log n).

## A Job Sequencing Problem

- Given a set of jobs where every job has a deadline and associated with profit if
the job finishes within the deadline.
- Each job takes 1 unit of time.
- How to maximise total profit if only one job can be scheduled at a time?
Job
A
B
C
D
E
Deadline
2
1
2
1
3
Profit
100
20
30
25
15

## Greedy Algorithm Summary

Problem
Greedy Choice
Works?
Why?
0-1 Knapsack
Take highest value/weight
first
No
Items cannot be split;
combinations matter
Fractional Knapsack
Take highest value/weight
first
Yes
Items can be split
Activity Selection
Choose earliest finishing
activity
Yes
Leaves maximum room for
future activities
Huffman Coding
Merge two lowest
frequencies
Yes
Rare characters can safely
receive longer codes
Job Sequencing
Choose highest profit, place
latest before deadline
Yes
Preserves earlier slots for
tighter deadlines
A greedy algorithm makes the best-looking local choice at each step, but that choice is only valid when
it is safe.

## In the next lecture..

Lecture 10: Dynamic Programming
