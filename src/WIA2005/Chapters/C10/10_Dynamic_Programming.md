# Chapter 10: Dynamic Programming

```
“Last time, we saw greedy can fail. 
Today, we learn what to do when 
greedy is not enough.”
```

## From Greedy to Dynamic Programming

By the end of this lesson, you should be able to explain how DP uses
“recurrence + table + traceback” to solve problems such as Fibonacci, Rod
Cutting, and 0-1 Knapsack.
In the greedy topic, we used 0-1
Knapsack to show that a locally
best choice does not always
produce the globally best solution.
Today, we revisit the same type of problem from a new angle.
Instead of asking:
“Which item looks best now?”
Dynamic Programming asks:
“What is the best solution for this capacity, using these items?”

## WIA2005: Algorithm Design

and Analysis
Lecture 10: Dynamic Programming
Asmiza A. Sani
Semester 1, Session 2025/26

## Learning objectives

- By the end of this lesson, you should be able to:
- Explain what makes a problem suitable for dynamic programming.
- Identify overlapping subproblems and optimal substructure.
- Compare memoization and tabulation.
- Solve simple DP problems involving:
- Fibonacci numbers
- Rod cutting
- 0-1 Knapsack

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

## What is Dynamic Programming?

- Dynamic programming is an algorithm paradigm that solves the optimisation
problem by breaking it down into simpler subproblems, provided that the
subproblems overlap—that is, when subproblems share subsubproblems.
- The optimal solution to the overall problem depends upon the optimal solution
to its subproblems.

## Dynamic Programming

- A dynamic-programming algorithm solves each subsubproblem just once and
then saves its answer in a table, thereby avoiding the work of recomputing the
answer every time it solves each subsubproblem.
A divide-and-conquer algorithm
does more work than
necessary, repeatedly solving
the common sub subproblems.

## Steps in Dynamic Programming

- There are four basic steps in applying the DP approach:
1.
Characterise the structure of an optimal solution.
2.
Recursively define the value of an optimal solution.
3.
Compute the value of an optimal solution, typically in a bottom-up fashion (tabulation).
4.
Construct an optimal solution from computed information.

## Watch this video

- Watch the video from 0:00 to 2:20:
https://youtu.be/e0CAbRVYAWg?si=dHTJtTBqgzu2-9Ep
- It introduce the concept of overlapping subproblem in dynamic programming
using the Fibonacci example.
- This video in relevant with the next 2 slides.

## Example – Fibonacci Number

- To calculate the Fibonacci numbers, we can use the following:
def fib(n):


if n < 2:



return n


return fib(n-1) + fib(n-2)

## Optimal substructure and overlapping subproblem

fib(n) = fib(n-1) + fib(n-2)
fib(5)
fib(3)
fib(4)
fib(1)
fib(2)
fib(3)
fib(2)
fib(2)
fib(1)
T(n) = 2T(n-1) + 1
O(2n)
fib(1)
fib(0)

## Watch this video

- Watch the whole video
https://youtube.com/shorts/hJl6A_ckC9g?si=srjafJEWEJFvXjBt
- This video explains the 2 methods for dynamic programming. After watching
the video, please read the details in the next 5 slides.

## Dynamic Programming methods

- There are two ways to apply the dynamic programming:
1. Memoization (Top-Down approach)
2. Tabulation (Bottom-up approach)

## Memoization

- In this approach, the procedure is naturally recursive, but modified to save the
result of each subproblem (usually in an array or a hash table).
- The procedure now first checks to see whether it has previously solved this
subproblem.
- If so, it returns the saved value, avoiding further computation at this level; if
not, it computes the value in the usual manner.
- The recursive procedure has been memoised; it “remembers” what results it
has computed previously.

## Bottom up (Tabular)

- This approach typically depends on some natural notion of the “size” of a
subproblem, such that solving any particular subproblem depends only on
solving “smaller” subproblems.
- The subproblems are sorted by size and solved in size order, from smallest to
largest.
- When solving a particular subproblem, all the smaller subproblems have
already been solved; its solution depends on these previously saved solutions.
- Each sub-problem I solved only once, and when we first see it, we have already
solved all of its prerequisite subproblems.

## Comparing memoization and bottom up

- These two approaches yield algorithms with the same asymptotic running
time, except in unusual circumstances where the top-down approach does not
actually recurse to examine all possible subproblems.
- The bottom-up approach often has much better constant factors, since it has
less overhead for procedure calls.

## Example – Fibonacci Number with DP (Top Down)

- To calculate the Fibonacci numbers, we can use the following:
def fib(n):
if n in memo:
return memo[n]

if n < 2:

return n
memo[n] = fib(n-1, memo) + fib(n-2, memo)
return memo[n]

## Activity

Find examples of daily life activity that applies the dynamic programming
concept.
Let’s stop for a few minutes…
Write them here

## Watch this video

- Watch the whole video
https://youtu.be/re9rF9SqRFc?si=dmloAjReWyOuGV5D
- This video explains the example for dynamic programming – the Rod Cutting
Problem. After watching the video, please read the details in the next 8 slides.

## Rod Cutting Problem

- Examines the problem of cutting a rod into rods of smaller length in way that
maximizes their total value.
- Given a rod of length n inches and a table of prices pi for i = 1, 2, 3, …, n,
determine the maximum revenue rn obtainable by cutting up the rod and
selling the pieces.
- Note that if the price pn for a rod of length n is large enough, an optimal
solution may require no cutting at all.

## Example

- Consider the case when n = 4.
- We see that cutting a 4-inch rod into two 2-inch pieces produces revenue p2 +
p2 = 5 + 5 = 10, which is optimal.

## How to determine best cut

- We can cut up a rod of length n in 2n-1 different ways, since we have an
independent option of cutting, or not cutting, at distance i inches from the left
end, for i =1, 2, 3, …, n-1.
- If an optimal solution cuts the rod into k pieces, for some  1≤k≤n, then an
optimal decomposition:
of the rod into pieces of lengths i1, i2, . . . , ik provides maximum corresponding revenue

## Optimal revenue figures

- For i = 1, 2, …, 10, by inspection, with the corresponding optimal
decompositions
- More generally, we can frame the values rn for n≤1 in terms of optimal
revenues from shorter rods:

## Recursive top-down implementation

- The following procedure implements the computation implicit in equation in a
straightforward, top-down, recursive manner.
Recursion tree showing the recursive calls
for CUT-ROD(p,n) where n = 4
Why is CUT-ROD
so inefficient?

## Using dynamic programming for optimal rod cutting

- A naïve recursive solution is inefficient because it solves the same
subproblems repeatedly; therefore, applying DP avoids recomputing.
- Dynamic programming thus uses additional memory to save computation time;
it serves as an example of a time-memory trade-off.
- The savings may be dramatic: an exponential-time solution may be
transformed into a polynomial-time solution.
- A dynamic-programming approach runs in polynomial time when the number
of distinct subproblems involved is polynomial in the input size and each such
subproblem can be solved in polynomial time.

## Memoization approach to Rod Cutting Problem

T(n) = (n2)

## Tabulation approach to Rod Cutting Problem

T(n) = (n2)

## Watch this video

- Watch the whole video
https://youtu.be/qxWu-SeAqe4?si=xh3iOEwOOrGMTJrK
- This video explains the example for dynamic programming – the Knapsack
Problem. After watching the video, please read the details in the next 8 slides.
- Then try it on another example given in the last slides.

## Knapsack Problem

- The knapsack problem is when given a set of items, each with a weight and a
value, we determine what are the subset of items to include in a collection so
that the total weight is less than or equal to a given limit and the total value is
as large as possible.
- Based on the characteristic of the items, knapsack problem can be
categorised into:
- Fractional Knapsack
- 0-1 Knapsack
We have look at this
problem briefly in
Greedy Algorithm
Lecture.

## Example 0-1 Knapsack Problem

- Let say, there is a thief robbing a store.
- He can only carry a maximum weight of W into his knapsack. Let say, W = 8
- There are n items (n = 4) available in the store and the weight of ith item
is wi and its profit is vi, as given in the table below.

What items should the thief take?
Item (i)
1
2
3
4
vi
1
2
5
6
wi
2
3
4
5

## Developing a Dynamic Programing algorithm for 0-1

Knapsack Problem
Step 1: Decompose the problem into smaller problems.
- We construct an array V[0..n, 0..W]
- For 1 ≤ i ≤ n, and 0 ≤ w ≤ W, the entry V[i, w] will store the maximum
computing time of any subset of files {1,2,…,i} of size at most w.
- If we can compute all the entries of this array, then the array entry V[n, W] will
contain the maximum computing time of files that can fit into the storage.

## Developing a Dynamic Programing algorithm for 0-1

Knapsack Problem
Step 2: Recursively define the value of an optimal solution in terms of solution to
smaller problems.
- Initial Settings: Set
- Recursive Step: Use

## Developing a Dynamic Programing algorithm for 0-1

Knapsack Problem
Step 3: Bottom-up computing V[i, w] (using iteration, not recursion).
- Bottom: V[0,w] = 0 for all 0 ≤ w ≤ W
- Bottom-up computation: Computing the table row by row using

## Developing a Dynamic Programing algorithm for 0-1

Knapsack Problem
Step 4: Construct an optimal solution from computed information.
- The maximum value (profit) = 8
- The items included is {2, 4}
2
4
i
vi
wi
0
1
2
3
4
5
6
7
8
0
0
0
0
0
0
0
0
0
0
0
0
1
1
2
0
0
1
1
1
1
1
1
1
2
2
3
0
0
1
2
2
3
3
3
3
3
5
4
0
0
1
2
5
5
6
7
7
4
6
5
0
0
1
2
5
6
6
7
8

## To find the items included is the sack:

1. Max value (profit) is in the last cell.
2. Look if the the row for item before has the same value.
1.
If yes, repeat 2, else include item in the bag.
3. Update the available sack weight by minus the weight of item included.
4. Look at the the value for the weight in the row before the item that has
included.
5. Repeat 2.

## 0-1 Knapsack Pseudocode

T(n) = (nW)

## Another example..

Step 4: Construct an optimal solution from
computed information.
- Let W = 10 and
- The maximum value (profit) = 90
- The items included is {2, 4}
2
4

## In the next lecture..

Lecture 11: Swarm Algorithms
