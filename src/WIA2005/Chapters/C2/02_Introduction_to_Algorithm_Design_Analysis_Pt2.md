# Chapter 2: Introduction to Algorithm Design & Analysis Fundamentals (Part 2)

```
WIA2005: Algorithm Design 
and Analysis
Lecture 2: Introduction to Algorithm Design & Analysis Fundamentals (Pt2)
Asmiza A. Sani
Semester 2, Session 2025/26
```

## Learning Objectives

- The students will:
- Understand and analyse time complexity of recursive algorithm using the following
methods:
- Back Substitution
- Recursion Trees
- Master Methods

## Recursive Algorithm

- A recurrence is an equation or inequality that describes a function in terms of
its value on smaller inputs.
- The repeated application of a recursive function within itself to solve a
problem.
- Recurrences go hand in hand with the divide-and-conquer paradigm
- because they give a natural way to characterize the running times of divide-and-conquer
algorithms.

## Properties of Recursive Function

- To analyse running time complexity of a recursive function, we need to
know (especially for back substitution and recursion tree):
- Base Case - terminates scenario that does not use recursion to produce an answer
- A Set of Conditions - reduces all othercases towards the Base Case

## function1(n)

{
if ( n > 0 )
print n
return function1(n – 1)
}
This function calls itself with a
new n value (n-1).
Example of recursive function and it’s recurrence relation

## Example of recursive function and it’s recurrence relation

EXAMPLE
- Factorial (denoted by !) is a function
that calculate the product of all positive
integers less than or equal to n.
- n! = n x (n-1) x (n-2) x (n-3) x … x 3 x 2 x 1
- 5! = 5 x x 4 x 3 x 2 x 1
factorial(n) {
if n == 0
return 1;
else
return n * factorial(n-1);
}
What is the recurrence
relation for factorial(n)
function?

## Recurrence Relation

EXAMPLE
- Factorial (denoted by !) is a function
that calculate the product of all positive
integers less than or equal to n.
- n! = n x (n-1) x (n-2) x (n-3) x … x 3 x 2 x 1
- 5! = 5 x x 4 x 3 x 2 x 1
factorial(n) {
if n == 0
return 1;
else
return n * factorial(n-1);
}

## Analysing recursive algorithm

## Methods for solving recurrences

- There are three methods for solving recurrences:
- Substitution method, we guess a bound and then use mathematical induction to prove
our guess correct.
- Recursion-tree method converts the recurrence into a tree whose nodes represent the
costs incurred at various levels of the recursion. We use techniques for bounding
summations to solve the recurrence.
- Master method provides bounds for recurrences of the form
- where a ≥ 1, b > 1, and f (n) is a given function

## Analysis of Recursive Algorithm:

(1) Back Substitution Method
- The back substitution method for solving recurrences comprises two steps:
1.
Guess the form of the solution.
2.
Use mathematical induction to find the constants and show that the solution works.

## Example 1: Back Substitution Method

What happened here?
We are trying to find how T(n)
is reduced to the base case.
Step 1: How can we write this in terms of summation?
- 
T(n) = 1 + T(n-1) – (1)
Step 2: Find the equation for the next call, (n-1)
- 
T(n-1)= 1 + T([n-1] -1)
= 1 +T(n-2) – (2)
Step 3: Repeat step 2 for (n-2)
- 
T(n-2)= 1 + T([n-2]-1)
= 1 +T(n-3) – (3)
T(n) = 1 +T(n-1) for n>0; T(0) = 1

## Example 1: Back Substitution Method

Step 4: Substitute (2) into (1)
- T(n)= 1 + [1 + T(n -2)] – (4)
= 2 + T(n-2)
Step 5: Substitute (3) into (4)
- T(n)= 2 + [1 + T(n-3)]
= 3 + T(n-3)
Step 6: T(n) gradually decrease as the loop A(n)recurs.
Base case T(0) = 1
- T(n) = k + T(n-k) – (5)
T(n) = 1 +T(n-1) for n>0; T(0) = 1

## Example 1: Back Substitution Method

Step 7: We know that the base case (where the recursion
stops) is 1, therefore T(n-k) (from (5)) = 1 Find k.
- n – k
= 0
k
= n
Step 8: Insert k into (5)
- 
T(n)
= [n] + T(n – [n])
= (n) + T(0)
= n
Step 9: Running time complexity.
- 
T(n) = O(n)
We already know
this is 1.
T(n) = 1 +T(n-1) for n>0; T(0) = 1

## Example 2: Back Substitution Method

- Given the recursive function B is:
T(n) = n + T(n-1) ; n > 0 and T(1) = 1
- Using substitution method, find the order of function B.

## Example 2: Back Substitution Method

Step 1: How can we write this in terms of summation?
- 
T(n) = n + T(n-1) – (1)
Step 2: Find the equation for the next call, (n-1)
- 
T(n-1)= [n-1] + T([n-1] -1)
= (n-1) + T(n-2) – (2)
Step 3: Repeat step 2 for (n-2)
- 
T(n-2)=[n-2] + T([n-2]-1)
= (n-2) +T(n-3) – (3)

## Example 2: Back Substitution Method

Step 4: Substitute (2) into (1)
- T(n)
= n + [(n-1) + T(n-2)] – (4)
Step 5: Substitute (3) into (4)
- T(n)
= n + (n-1) + [(n-2) + T(n-3)]
Step 6: T(n) gradually decrease as the loop A(n) recurs. Base case
T(1) = 1
- T(n) = n + (n-1) + (n-2) + (n-3) + …  [n-(k-1) + T(n-k)] – (5)

## Example 2: Back Substitution Method

Step 7: We know that the base case (where the recursion stops) is 1, therefore T(n-k) (from (5)) = 1 Find k.
- n – k = 1
k = n - 1
Step 8: Insert k into (5)
T(n)
= n + (n-1) + (n-2) + (n-3) + … + [n-([n-1]-1) + T(n-[n-1])]
= n + (n-1) + (n-2) + (n-3) + … + 2 + T(1)]
= n + (n-1) + (n-2) + (n-3) + … + 2 + 1
= [n(n+1)]/2
= (n2+n)/2
Step 9: Running time complexity.
- 
T(n) = O(n2)
We already know
this is 1.
Arithmetic series (1)

## Analysis of Recursive Algorithm:

(2) Recursion Tree Method
- In a recursion tree, each node represents the cost of a single subproblem
somewhere in the set of recursive function invocations.
- We need to determine the total cost, then sum the costs within each level of
the tree to obtain a set of per-level costs is calculated, and then we sum all the
per-level costs.
- A recursion tree is best used to generate a good guess, which you can then
verify by the substitution method (or master method).

## Example of Recursion-Tree Method (1)

- Let say, we have the following function:
- We can write the recursive function relation as:
T(n) = 2T(n/2) + C
function2(n)
if n == 1
return 1
else
return function2(n/2) + function2(n/2)

## C

; n = 1
2T(n/2) + C; n >1
T(n) =
Example of Recursion-Tree Method (1)

## T(n/2)

T(n/2)
C
Step 1: Recursive call number 1
Example of Recursion-Tree Method (1)

## Step 2: Recursive call number 2

C
C
C
T(n/4)
T(n/4)
T(n/4)
T(n/4)
Example of Recursion-Tree Method (1)

## Step 3: Recursive call number 3

C
C
C
C
C
C
T(n/8)
T(n/8)
T(n/8) T(n/8) T(n/8) T(n/8) T(n/8) T(n/8)
Example of Recursion-Tree Method (1)
C

## Step 4: Recursive call number n

C
C
C
C
C
C
C
T(n/8)
T(n/8) T(n/8) T(n/8) T(n/8) T(n/8) T(n/8)
T(1)
20 C
21 C
22 C
T(n/8)
23 C
2kC
T(1)
T(1)
T(1)
Example of Recursion-Tree Method (1)

## Example of Recursion-Tree Method (1)

Step 5: Calculate the total cost for each call.
- T(n) = c(20 + 21 + 22 + 23 + … + 2k)
Step 6: Running time complexity
- T(n) = O(n)
k = log2n
Geometric series (6)
(2log 2n -1)

## Example of Recursion-Tree Method (2)

- Given the recursive function relation:
T(n) = 2T(n/2) + n
- Using recursion tree method, find the order of function.

## Example of Recursion-Tree Method (2)

1
, n=1
2T(n/2) + n, n >1
T(n) =

## T(n/2)

T(n/2)
n
Step 1: Recursive call number 1
Example of Recursion-Tree Method (2)

## Step 2: Recursive call number 2

n
n/2
n/2
T(n/4)
T(n/4)
T(n/4)
T(n/4)
Example of Recursion-Tree Method (2)

## Step 3: Recursive call number 3

n
T(n/8)
n/2
n/2
n/4
n/4
n/4
n/4
T(n/8)
T(n/8) T(n/8) T(n/8)T(n/8) T(n/8) T(n/8)
Example of Recursion-Tree Method (2)

## Step 4: Recursive call number n

n
n/2
n/2
n/4
n/4
n/4
n/4
n/8
n/8
n/8
n/8
n/8
n/8
n/8
n/8
…
T(1)
n
n
n
n
…
…
…
…
T(1)
......
n
T(1)
There are
log n layers.
Example of Recursion-Tree Method (2)

## Example of Recursion-Tree Method (2)

Step 6: Calculate the cost for each call.
- T(n) = n + n + n + n + … + n – for k times (layers)
- Since there are (log n) layers, the number of k is log n.
Step 7: Running time complexity
- T(n) = n x (log n)
= O( n log n)

## Analysis of Recursive Algorithm:

(3) Master Method
- The master method provides a “cookbook” method for solving recurrences of
the form
- where a ≥ 1 and b > 1 are constants and f(n) is an asymptotically positive function.

## Conditions for Master Method

Main pattern of recurrence relations:
T n = aT
ൗ
n b + Θ nklogpn
Where, a ≥1 , b > 1, k ≥0, p = real number
f(n)

## Conditions for Master Method

T n = aT
ൗ
n b + Θ nklogpn
where ,a ≥1 , b > 1, k ≥0, p = real number
Case 1: If logb a > 𝑘then, 𝑇𝑛= Θ(𝑛log𝑏𝑎)
Case 2: If logb a = 𝑘then
a) If 𝑝> −1, then, 𝑇𝑛= Θ 𝑛𝑘𝑙𝑜𝑔𝑝+1 𝑛
b) If 𝑝= −1, then, 𝑇𝑛= Θ 𝑛𝑘𝑙𝑜𝑔log 𝑛
c) If 𝑝< −1, then, 𝑇𝑛= Θ 𝑛𝑘
Case 3: If logb a < 𝑘then
a) If 𝑝≥0, then, 𝑇𝑛= Θ 𝑛𝑘𝑙𝑜𝑔𝑝𝑛
b) If 𝑝<0, then, 𝑇𝑛= O 𝑛𝑘

## Example Case 1

a) 𝑇𝑛= 16𝑇
Τ
𝑛4 + n
b) 𝑇𝑛= 3𝑇
Τ
𝑛2 + n

## Example Case 1

a) 𝑇𝑛= 16𝑇
Τ
𝑛4 + n
b) 𝑇𝑛= 3𝑇
Τ
𝑛2 + n
Solution:  a=16 , b=4 , f(n) = n, k = 1, p = 0
log4 16 >  1 – Case 1: logb a > 𝒌
Therefore:
T(n) =Θ n2
Solution:  a=3 , b=2 , f(n) = n, k = 1, p = 0
log2 3 >  1 – Case 1: logb a > 𝒌
Therefore:
T(n) =Θ nlog2 3

## a) T n = 4T

Τ
n 2 + n2
b) T n = 2T
Τ
n 2 + n log n
c) T n = 2T
Τ
n 2 +
n
log n
d) T n = 2T
Τ
n 2 + n log−2 n
Example Case 2

## a) 𝑇𝑛= 4𝑇

Τ
𝑛2 + 𝑛2
b) 𝑇𝑛= 2𝑇
Τ
𝑛2 + 𝑛𝑙𝑜𝑔𝑛
Example Case 2
Solution:  a=4 , b=2 , f(n) = n2, k = 2, p = 0
log2 4 =  2 and p > -1 – Case 2: logb a = 𝒌
Therefore:
T(n) = Θ 𝑛2 𝑙𝑜𝑔𝑛
Solution:  a=2 , b=2 , f(n) = n log n, k = 1, p = 1
log2 2 =  1 and p > -1 – Case 2: logb a = 𝒌
Therefore:
T(n) = Θ(n log 2n)

## Example Case 2

c) T n = 2T
Τ
n 2 +
n
log n
d) T n = 2T
Τ
n 2 + n log−2 n
Solution:  a=2 , b=2 , f(n) = n log n, k = 1, p = -1
log2 2 =  1 and p = -1 – Case 2: logb a = 𝒌
Therefore:
T(n) = Θ(n log log n)
Solution:  a=2 , b=2 , f(n) = n log n, k = 1, p = -2
log2 2 =  1 and p < -1 – Case 2: logb a = 𝒌
Therefore:
T(n) = Θ(n)

## Example Case 3

a)T n = 6T
Τ
n 3 + n2log n
b) T n = 7T
Τ
n 49 + n2 log n
Solution:  a=6 , b=3 , f(n) = n2 log n, k = 2, p = 1
log3 6 <  2 and p ≥0 – Case 3: logb a < 𝒌
Therefore:
T(n) = Θ(n2 log n)
Solution:  a=7 , b=49 , f(n) = n2 log n, k = 2, p = 1
log49 7 <  2 and p ≥0 – Case 3: logb a < 𝒌
Therefore:
T(n) = Θ(n2 log n)

## Example (Others)

- Using the masters theorem, solve the following problem:
T(n) = 0.5T(n/2) + 1/n
a <= 1, therefore masters theorem cannot be applied to solve the problem.

## Inadmissible equation

These equation cannot be
solve using Masters
Theorem!

## Class activity

- From our lecture, we have seen that the running time of:
T(n) = 2T(n/2) + n
is O(n log n) using the recursion tree.
- Apply the back substitution method and master theorem to find the running
time complexity of this relation.

## In the next lecture..

Lecture 3: Sorting Algorithm

## References

- Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein.
2009. Introduction to Algorithms, 3rd edition. MIT Press.
- Robert Sedgewick and Kevin Wayne. 2011. Algorithm. 5th Edition. Addison-
Wesley.
- Time complexity analysis of recursive program
- https://www.youtube.com/watch?v=gCsfk2ei2R8&list=PLEbnTDJUr_IeHYw_sfBOJ6gk5pie
0yP-0&index=3
- Masters Theorem
- https://www.youtube.com/watch?v=lPUhHmgrpik&list=PLEbnTDJUr_IeHYw_sfBOJ6gk5pie
0yP-0&index=5
