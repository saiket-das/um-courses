# Chapter 7: Probabilistic Analysis and Randomised Algorithms

```
WIA2005: Algorithm Design and 
Analysis
Lecture 7: Probabilistic Analysis and Randomised Algorithms
Dr. Asmiza A. Sani
Semester 2, Session 2025/26
```

## Let’s ponder for a bit…

Algorithm A always takes 10 steps. Algorithm B takes 2 steps most of the time,
but occasionally takes 100.
Which is better?

## Why does this matter?

- Worst case is not everything.
- The average case can be misleading if computed badly.
- Rare events matter.
- Randomness can be a design tool.

## Imagine facing decisions in a tough environment full of tricky

inputs, biased data, or unfamiliar patterns.
Would you prefer to rely on a clear,
predictable rule or embrace some
controlled randomness to navigate more
effectively?

## Deterministic Worst-Case vs Expected Performance

- Deterministic algorithms:
- Vulnerable to adversarial input
- Worst-case may be rare but catastrophic
- Randomised algorithms:
- Guarantee expected performance
- Input order becomes irrelevant
Deterministic
Randomised
Worst-case is fixed
Worst-case is probabilistic
Inputs controls outcome
Algorithm controls randomness
Predictable
Hard to exploit

## Learning Objectives

- Know and understand what are:
- Know what is Probabilistic Analysis
- Know Randomized Algorithm

## Probabilistic Analysis  Fundamentals

- Random variables
- Expectation (Linearity of Expectation)
- Indicator random variables
- Expected running time vs actual running time

## Probabilistic Analysis

- The running time complexity of an algorithm often depends on the distribution
of the input data.
- To reason about what is the average running time complexity for an algorithm,
we need to know the distribution of possible input.
- If the algorithm implements randomization, then the analysis will become
complex.
- But we can formally use the Indicator Random Variable (IRV) to analyse this kind of
problem.

## Probabilistic Analysis

- Up until now, the analysis that we have done, calculates how many times a
certain function do calls or loops in the algorithm for a specified input size.
- In this topic, we will see instead, how to calculate the cost of a specific input,
and determine what is the probability of each elements.
- We analyse algorithms not by what might happen, but by what happens on average, even
if outcomes are dependent.

## Problem:  Hiring an assistant.

To represent the distribution of possible input, we will use the hiring an assistant
problem where the sequence of candidates will simulate input distribution and
cost.
Let say, the number of candidates = n.
The company will interview one candidate per day (Cost of
interview each candidate =  Ci). If the candidate is better than
the current assistant, must fire the assistant and hire the
candidate. (Cost of hiring any candidate =  Ch)
Goal:  Estimate the cost of this strategy.
n candidates
Go for an interview
Estimate the total cost of
interviewing and hiring.

## Pseudocode:

The cost model in this case is not finding out
what is the running time for HIRE-
ASSISTANT, but instead the actual cost
incurred by interviewing and hiring.

## Note

- Since all candidates (n) must be interviewed, the  interview cost Ci is
unavoidable. (This cost is incurred for every input.) If m candidates are hired,
the hiring cost is mCh.
- The total cost: O(nCi + mCh).
- Hiring cost is mCh varies with the input.
- So, we will focus on analysing this cost.

## Goals of Probabilistic Analysis of Hiring Problem?

- What we want:
- Best Case –
- What we do not want:
- Worst Case –
- What we probably can get:
- Average Case –

## Goals of Probabilistic Analysis of Hiring Problem

- What we want:
- Best Case – pay only the cost for hiring the best candidate.
- What we do not want:
- Worst Case – pay the cost for hiring all candidates.
- What we probably can get:
- Average Case – pay less for the cost of hiring one candidate.

## Using Probabilistic Analysis

- To use probabilistic analysis, we need to have 2 conditions:
- Assumption can be made on the inputs to the problem
- Inputs are chosen from a known probability distribution.
- Input sequence is random
- To note: The algorithm itself is deterministic.

## Hiring Problem: Worst-case analysis

- Worst case: Hire every candidate that we interview.
- If candidate list sent by the employment agency is (unknown to the company)
in increasing order of quality;
- that is, candidate i is better than candidate  i − 1, 1 ≤ i ≤ n.
- Every candidate (n) is hired.
- Therefore,  hiring cost =O(nCh).
What would happen and how
would you avoid this from
happening?
Increasing rank
Go interview

## Randomized Algorithm

- By tweaking the hiring algorithm to use a randomised algorithm, we can avoid
the worst case from happening.
- How? We can include a random selection of candidates to be called for the
interview.
- If we do this:
- No assumption about the probability distribution of inputs.
- The algorithm uses random numbers.
- May produce different outputs for the same input at different times.
Now, how can we reason about the
probability distribution of hiring the
candidates?

## Indicator Random Variable (IRV)

- Indicator Random Variable (IRV) is a method for converting between
possibilities and expectations of random variables.
- A random variable (e.g., X) is a variable that specify the range of the probability
distribution.
- An expected value of a random variable (e.g., E[X]) is the average value that we
get from sampling the random variable repeatedly.
- Suppose we are given a sample space S and an event A. Then the indicator
random variable I{A} associated with event A is defined as

## Lemma 1

- Given a sample space S and an event A in the sample space S.
- Let’s define the random variable:
XA = I{A}
Therefore, we can say that the expected value XA :
E[XA] = Pr{A}

## Proof of Lemma 1

- By the definition of an indicator random variable and the definition of expected
value, we can say that:

## Example - Coin Flip (Single flip)

- Sample space is S={H,T} , with Pr{H} = Pr{T} = 1/2.
- Indicator random variable XH (or I{H}), is associated with the coin coming up
heads, which is the event H.
- This variable counts the number of heads obtained in this flip, and it is 1 if the
coin comes up heads and 0 otherwise. We write

## Example - Coin Flip (Single flip)

- The expected number of heads obtained in one flip of the coin is simply the
expected value of our indicator variable XH :

## Example - Coin Flip (flip n times)

Let X be a random variable value for getting
heads (H) in n flips.
1. First, let’s break X into smaller parts. We can
specify the random variable for a getting H in a
single flip.


2. Then, we can say that the random variable X
is the sum Xi for n flips.
3. Finally, we calculate the expected value of X by
following the principle of Linearity of Expectation.
Xi= I [the ith flip H}

## Analysis of hiring problem using IRV

- Now we will apply IRV on hiring problem.

## A randomized algorithm for Hiring Problem

- Previously, we have decided that the best way to avoid the worst case is to
randomly call the candidates from the list for an interview.
- The new randomize algorithm:
- Take the list of candidates as an input to the algorithm.
- The algorithm will randomly permute the list to generate the order in which candidates are
interviewed.
- If this is done in such a way that each of the n! permutations is equally likely,
then the previous analysis can be used.

## A randomized algorithm for Hiring Problem

## Analysis of hiring problem using IRV

- Let Xi be the indicator random variable associated with the event in which the ith
candidate is hired. Thus,
- We know that,
and we must therefore compute the probability that lines 5–6 of HIRE-ASSISTANT are
executed.

## Analysis of hiring problem using IRV

- Candidate i is hired, in line 6, exactly when candidate i is better than each of
candidates 1 through i - 1.
- Because we have assumed that the candidates arrive in a random order, the
first i candidates have appeared in a random order.
- Any one of these first i candidates is equally likely to be the best-qualified so far.
- Candidate i has a probability of 1/i of being better qualified than candidates 1
through i - 1 and thus a probability of 1/i of being hired.

## Analysis of hiring problem using IRV

- Now we can compute E[X]:
Linearity of Expectation
Harmonic Series

## Example

Using Order Statistics

## Order statistics

- The ith order statistic of a set of n elements is the ith smallest element.
- For example, the minimum of a set of elements is the first order statistic (i =
1), and the maximum is the nth order statistic (i = n).
- A median, informally, is the “halfway point” of the set.
- n is odd (unique)
- n is even, median occur at 2 places, i = n/2 and i = n/(2+1)
- lower median
- Upper median

## Example

- Given n elements in an array, find the ith smallest number (element of rank i)
- Naïve algorithm
- Sort A
- return A[i]

## Minimum and maximum

- How many comparisons are necessary to determine the minimum of a set of n
elements?
What if we want to find the median or any
other element rank in the array?

## Selection in expected linear time

- Randomized divide-and-conquer.
- The algorithm RANDOMIZED-SELECT is modeled after the quicksort algorithm.
- As in quicksort, the input array is partitioned recursively.
- But unlike quicksort, which recursively processes both sides of the partition,
RANDOMIZED-SELECT works on only one side of the partition.

## RANDOMIZED-SELECT

## Analysis of RANDOMIZED-SELECT

- The procedure RANDOMIZED-PARTITION is equally likely to return any element
as the pivot.
- Therefore, for each k such that 1≤ k≤ n, the subarray A[p..q] has k elements
(all less than or equal to the pivot) with probability 1/n. For k = 1, 2,..,n, we
define indicator random variables Xk where
- and so, assuming that the elements are distinct,

## • Let T(n) be the random variable of Randomize-Select on n

input size assuming they are independent
Taking expected values

## • In order to apply equation (C.24), we rely on Xk and T(max(k-

1, n-k)) being independent random variables.
- Let us consider the expression max T(max(k-1, n-k))

## • Show E[T(n)] = O(n)

by substitution
- Assume E[T(n)] ≤ cn
for some constant c
that satisfies the
initial conditions of
the recurrence.
- Using inductive
hypothesis
Since we can pick c large enough so that
c(n/4 + 1/2) dominates the O(n) term.

## Select vs Randomised Select

- Select algorithm running time is O(n) in the worst case while Randomised
Select runs in O(n) in expected time.
- Like RANDOMIZED-SELECT, the algorithm SELECT finds the desired element by
recursively partitioning the input array.
- However, in the Select algorithm, a good split is guaranteed upon partitioning
the array.
- SELECT uses the deterministic partitioning algorithm PARTITION from quicksort
but modified to take the element to partition around as an input parameter.

## SELECT algorithm

- SELECT(i,n)
1.
Divide the n elements of the input array into floor(n/5) groups of 5 elements each and at
most one group made up of the remaining n mod 5 elements.
2.
Find the median of each of the ceiling(n/5) groups by first insertion-sorting the elements of
each group (of which there are at most 5) and then picking the median from the sorted list
of group elements.
3.
Use SELECT recursively to find the median x of the ceiling(n/5) medians found in step 2. (If
there are an even number of medians, then by our convention, x is the lower median.)
4.
Partition the input array around the median-of-medians x using the modified version of
PARTITION. Let k be one more than the number of elements on the low side of the partition,
so that x is the kth smallest element and there are n-k elements on the high side of the
partition.
5.
If i = k, then return x. Otherwise, use SELECT recursively to find the ith smallest element on
the low side if i < k, or the (i-k)th smallest element on the high side if i > k.

## SELECT algorithm in picture

## Analysis of SELECT algorithm

- First, determine a lower bound on the number of elements that are greater
than the partitioning element x
- At least half of the medians found in step 2 are greater than or equal to the
median-of-medians x.
- Thus, at least half of the ceiling(n/5) groups contribute at least 3 elements
that are greater than x, except for the one group that has fewer than 5
elements if 5 does not divide n exactly, and the one group containing x itself.
- Discounting these two groups, it follows that the number of elements greater
than x is at least
Thus, in the worst case, step
5 calls SELECT recursively on
at most 7n/10 +6 elements.

## Worst-case running time for SELECT

Show the running time is linear by substitution: T(n) ≤ cn for some suitably
large constant c and all n > 0

## Reference

- Cormen, Lieserson and Rivest, Introduction to Algorithms, Third Edition, MIT
Press, 2009.

## In the next lecture..

Lecture 10: Network Flow Algorithm
