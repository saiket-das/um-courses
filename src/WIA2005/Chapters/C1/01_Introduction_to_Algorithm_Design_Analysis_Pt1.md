# Chapter 1: Introduction to Algorithm Design & Analysis Fundamentals (Part 1)

```
WIA2005: Algorithm Design 
and Analysis
Lecture 1: Introduction to Algorithm Design & Analysis Fundamentals (Pt1)
Dr. Asmiza A. Sani
Semester 2, Session 2025/26
```

## Learning Objectives

- The student will:
- Know the concept of algorithm.
- Understand and analyse time complexity of iterative algorithm.

## What is Algorithm?

- Informally, an algorithm is any well-defined computational procedure that
takes some value, or set of values, as input and produces some value, or set
of values, as output.
- We can also view an algorithm as a tool for solving a well-specified
computational problem.

## Why study algorithm?

Internet. Web
search, packet
routing, distributed
file sharing, ...
Biology. Human
genome project,
protein folding, ...
Computers. Circuit
layout, file system,
compilers, …
Computer graphics.
Movies, video
games, virtual
reality, ...
Security. Cell
phones, e-
commerce, voting
machines, ...
Multimedia. MP3,
JPG, DivX, HDTV,
face recognition, ...
Social networks.
Recommendations,
news feeds,
advertisements, ...
Physics. N-body
simulation, particle
collision
simulation, ...
Their impact is broad and far-reaching!
Old roots, new
opportunities.
Formalized by
Church and
Turing in
1930s.

## Why study algorithm?

Algorithms help us to
understand
scalability.
Performance often
draws the line
between what is
feasible and what is
impossible.
Algorithmic
mathematics provides
a language for talking
about program
behavior.
Performance is the
currency of
computing.
The lessons of
program performance
generalize to other
computing resources.

## Properties of Algorithm

- An algorithm possesses the following properties:
- It must be correct.
- It must be composed of a series of concrete steps.
- There can be no ambiguity as to which step will be performed next.
- It must be composed of a finite number of steps.
- It must terminate.
- A computer program is an instance, or concrete representation, for an
algorithm in some programming language.

## Analysing an Algorithm

- An algorithm can be analysed for different properties:
- Time
- Space
- Network consumption
- Power consumption
- CPU registers
For this course, we will only be
focusing on time analysis.

## How to describe how fast an algorithm is?

- Example 1: Both of the following codes gives the same output. Which one is a faster
Python code?
Code 1
1 sum = 0;
2 for index in range(201):
3
sum = sum + index
4 print(sum)
Code 2
1 sum = (200/2)*(200+1);

## How to describe how fast an algorithm is?

- 
Example 2: Both of the following codes gives the same output. Which one is a faster
Javascript code?
Code 1
1 function reverse(s) {
2
var o = ''; for (var i = s.length - 1; i >= 0; i--)
3
o += s[i];
4
return o; }
Code 2
1 function reverse(s) {
2
return s.split('').reverse().join(''); }

## What is the formal notation to describe running times of the

algorithm in the previous slide?

## How to describe how fast an algorithm is?

- Normally, what we probably do is run both programs and see how long it takes
to execute on a given input.
- Probably observe:
- One code is better than the other on certain input.
- One code is better than the other on a different machine.
- So instead, we will formally analyse algorithm based on the running time (or
space) in terms of the input size.
- Asymptotic analysis using Asymptotic Notation
Difficult to generalise about the
code performance that is
independent from its
implementation language and
platform specific execution time.

## Running time complexity – The

Asymptotic analysis

## Growth of Functions

- The properties to be observed in algorithm analysis is rate of growth, or order
of growth, of the running time
- Rate of growth: The rate at which running time increases as function of input.
- Represented as T(n).

## Time function characteristics

- Constant
- Logarithmic
- Linear
- Quadratic
- Cubic
- Exponential
1 < log n < √n < n < n log n < n2 < n3 < …. 2n < 3n < nn

## Growth of Functions

- Let’s say, we have 2 functions:
- f(n) = n2 (red)
- f(n) = n3 (green)
- Which one has the higher growth
rate?
n
T(n)
n0

## Which algorithm is better?

The higher growth rate?
OR
The lower growth rate?

## Which algorithm is better?

n
T(n)
n0
When n gets large enough, a
the (green) algorithm always
have a higher T(n) than the
(red) algorithm.
f(n) = n2
f(n) = n3

## Asymptotic Notation

Asymptotic notation can
be divided into 3 forms:
Big O notation (O) –
represents the worst time
(upper bound)
Big Omega notation (Ω) –
represents the best time
(lower bound)
Big Theta notation  (Θ) –
represents the average
time.

## Asymptotic Notation

- When we are looking for the approximation rate of growth of function in
asymptotic analysis, the lower order term and constant coefficients are
dropped.
f(n) = n3 + n + 5
Higher order
term
Lower order
term
Constant
coefficient
T(n) = Θ(n3)

## [Extra] Asymptotic Analysis– Why we dropped the lower

order term?
- Less interested the exact time required by algorithm but more in how the time
grows as the size of input increases.
- Example, given the worst-case time of an algorithm t(n) (measured in second)
is:
t(n) =  60n2 + 5n + 1
n
t(n) =  60n2 + 5n +
1
60n2
10
6051
6000
100
600,501
600,000
1000
60,005,001
60,000,000
10,000
6,000,050,001
6,000,000,000

## [Extra] Asymptotic Analysis– Why we dropped the lower

order term?
- Now, if we look at t(n) measures in minutes:
T(n) = n2 + (5/60)n + 1/60
- Changing of units does not affect how the time grows as the size of input
increases
- only the unit in which time is measured for input of size n.
- Look at higher order term and ignore the lower order term and constant
coefficients.
- Therefore, we can say:
T(n) = O(n2)

## Big O, Big Omega and Big Theta

## Big O-notation

- O-notation gives an upper bound for a function to within a constant factor. We
write f(n) = O(g(n)) if there are positive constants n0 and c such that at and to
the right of n0, the value of f(n) always lies on or below cg(n).

## Example Big-O notation

Let say,
- f(n)= n2
- g(n) = 1 * n3
f(n) = O(g(n))

## Example Big-O notation

Let say,
- f(n)= n2
- g(n) = 1 * n3
When c is less than 1,
f(n) = O(g(n))?

## f(n) = O(g(n))

Will still, at some point, g(n) beat f(n)

## Therefore..

- From the example, regardless of what is the value of c, g(n) will always beat
f(n) at some point (n0).
f(n) = O(g(n))

## Formal justification

f(n) ≤ cg(n) ; n ≥ n0 , n ≥ 1 and c > 0
f(n) = O(g(n))
Example: Let’s say, f(n) = 3n + 2 and g(n) = n2. Is f(n) = O(g(n))?
f(n) ≤ cg(n) ; n ≥ 1 and c > 0
3n + 2  ≤ c.n2 ; c = 1 and n ≥ 4
= 3n + 2 ≤ n2   -- proved
Therefore, f(n) = O(g(n))

## Big Ω-notation

- Ω-notation gives a lower bound for a function to within a constant factor. We
write f(n) = Ω(g(n)) if there are positive constants n0 and c such that at and to
the right of n0, the value of f(n) always lies on or above cg(n).

## Example Big Ω-notation

Let say,
- f(n)= n2
- g(n) = 1 * n3
g(n) = Ω (f(n))

## Formal justification

f(n) ≥ cg(n) ; n ≥ n0 , n ≥ 1 and c > 0
f(n) = Ω (g(n))
Example: Let’s say, f(n) = 3n + 2 and g(n) = n2. Is g(n) = Ω (f(n))?
g(n) ≥ cf(n) ; n ≥ 1 and c > 0
n2  ≥ c.3n + 2 ; c = 1 and n ≥ 4
= n2 ≥ 3n + 2 -- proved
Therefore, g(n) = Ω (f(n))

## Big Θ-notation

- Θ-notation bounds a function to within constant factors. We write f(n) = Θ(g(n))
if there exist positive constants n0, c1, and c2 such that at and to the right of
n0, the value of f(n) always lies between c1g(n)and c2g(n)inclusive.

## Example Big-Θ

Let say,
- f(n) = n2
- g(n) = n2 + n + 100

## Therefore..

- f(n) and g(n) have the asymptotic growth rate equivalence:
f(n) = Θ(g(n))

## Formal justification

c1g(n) ≤ f(n) ≤ c2g(n) ; n ≥ n0 , n ≥ 1 and c1, c2 > 0
f(n) = Θ (g(n))
Example: Let’s say, f(n) = 3n + 2 and g(n) = n. Is f(n) = Θ (g(n))?
(1)
f(n) ≥ c1g(n) ; n ≥ 1 and c > 0


3n + 2  ≥ c1n ; c1 = 1 and n ≥ 1


= 3n + 2 ≥ n  -- Proved
(2)
f(n) ≤  c2g(n) ; n ≥ 1 and c > 0


3n + 2 ≤  c2n ; c = 4 and n ≥ 1


= 3n + 2 ≥ n -- Proved
Therefore, f(n) = Θ (g(n))

## Best, Average and Worst-Case Running Time

- Analysis of algorithm always interested in Worst Time.
- Average time is used when there are no difference between best and worst
time.
- Best time are often not considered during analysis of algorithm.
5
1
7
9
2
4
Linear Search
Key to search: 9
A:
B(n) = O(1)
W(n) = O(n)
A(n) = O(n)
Key 9 is at index 1
Key 9 is at the last
index (n)
Key 9 is at any index
between 0 to n

## Representing Algorithm

Up until now you should have understood what is Asymptotic Analysis.
From this point on, we will be looking at algorithm and see what is the running time
complexity for each of them.
Before that, let’s look at how algorithm is written.

## Pseudocode

- Pseudocode is an informal representation to describe the algorithm.
- It uses conventional structure (intended for reading by human) which is almost
similar to programming language, but omits any machine essentials, for
example:
- Variable declarations
- System specific codes
- The purpose of pseudocode is to:
- Make comprehension of algorithm easier (human readable).
- Describe an implementation-independent algorithm.

## Example of Pseudocode

## Types of Algorithm

Algorithm
Iterative
Recursive

## Analysing Iterative algorithm

## Iterative Algorithm

- Iterative algorithm uses looping statements such as “for”, “while”, and “do-while”
to repeat the same steps.
CODE 1
1 for I in range (0,10,1)
2

print(“hello”)
CODE 2
1 i = 1
2 while ( i < 10) :
3

i+=1

## Analysis of Iterative Algorithm

Determine higher order term by calculating the time a
statement is executed:
operation
comparison
loop
pointer
reference
function
calls

## Analysis of Iterative Algorithm

- Problems that can be solve with iterative, can be solve using recursion as well,
and vice versa.
- But the time complexity analysis is different.

## Example Problem

- For example, we might need to sort a sequence of numbers into non-
decreasing order.
- Here is how we formally define the sorting problem:
Input:
5   2   4   6   1   3
Output:
1   2   3   4   5   6

## Operation of Insertion Sort

## Insertion Sort

## Analysis of Insertion Sort

- Before we apply the asymptotic analysis, we need to look at the algorithm.
- Intuitively, we can say that the running time depends on the input - an already
sorted sequence is easier to sort.
- Therefore, we want to look for the upper bounds.
- We also need to parameterize the running time by the size of the input, since
short sequences are easier to sort than long ones.
- Input = n values
- no assumptions can be made for n, but n is not always small.

## Running time complexity of Insertion Sort

To compute T(n), the running time of INSERTION-
SORT on an input of n values, we sum the
products of the cost and times columns,
obtaining:
Best running time
T(n) = Ω(n)
Worst running time
T(n) = O(n2)

## More example on analysis of

iterative algorithm

## Example 1

- Consider the following iterative program:

def function1 ():

for i in range (1,n,1)


print(“Hello world”)

## Example 1

- Consider the following iterative program:

The number of
loop “Hello word”
is going to be
printed is stated in
the condition
(n times)
Complexity = O(n)
def function1 ():

for i in range (1,n,1)


print(“Hello world”)

## Example 2

- Consider the following iterative program:

def function2():
for i in range (1,n,1)
for j in range(1,n,1) {
print(“Hello world”)

## Example 2

- Consider the following iterative program:


Outer 1: n times
Inner loop: n times
Complexity = O(n2)
def function2():
for i in range (1,n,1)
for j in range(1,n,1) {
print(“Hello world”)

## Example 3

- Consider the following iterative program:


def function3():
for i in range (n/2,n,1)

for j in range(n/2,n,1) {


for k in range(1,n,k*2) {



print(“Hello world”)

## Example 3

- Consider the following iterative program:


Loop 1: n/2 times
Loop 2: n/2 times
Loop 3: log2n
Complexity = O(n2log2n)
def function3():
for i in range (n/2,n,1)

for j in range(n/2,n,1) {


for k in range(1,n,k*2) {



print(“Hello world”)

## In the next lecture..

Lecture 2: Introduction to Algorithm Design & Analysis (Pt2)

## References

- Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein.
2009. Introduction to Algorithms, 3rd edition. MIT Press.
- Robert Sedgewick and Kevin Wayne. 2011. Algorithm. 5th Edition. Addison-
Wesley.
- Wikipedia
- Big O asymptotic notation, big theta and big omega –
- https://www.youtube.com/watch?v=8Y6gqjIxAlc
- https://www.khanacademy.org/computing/computer-science/algorithms/asymptotic-
notation/a/asymptotic-notation
- Time complexity analysis of iterative program
- https://www.youtube.com/watch?v=FEnwM-
iDb2g&index=2&list=PLEbnTDJUr_IeHYw_sfBOJ6gk5pie0yP-0

## Self-practice

## Example 4

def A ():

for I in range (n)

print (“Hello”)
1
2
3

## Example 5

def A ():

for i in range(n)

for j in range (n)

print (“Hello”)
1
2
3
4

## Example 6

def A ():

i = 1, s = 1

while (s <= n):

i++

s = s + i

print (“Hello”)

1
2
3
4
5
6

## Example 7

def A ():

for i in range (1,n,1)

for j in range (1, j<=i,1)


for k in range (1, 100, 1)


print(“Hello”)


1
2
3
4
5

## Example 8

def A ():

for i in range (1, n, 1)

for j in range (1, i2, 1)

for k in range (1, n/2, 1)

print (“Hello”)


1
2
3
4
5

## Example 9

def A ():

for i in range (1, i<=n, i*2)

print(“Hello”)
1
2
3

## Example 10

def A ():

for i in range (n/2, i<=n,1)

for j in range (1, j<=n/2, 1)


for k in range (1,k<=n, k * 2)



print(“Hello”)


Since no dependency among 3 loops
n
n
n
2
log
*
2
*
2
=
)
log
(
2
2
n
n
O
2
n
2
n
n
2
log
1
2
3
4
5

## Example 11

def A ():

for i in range (n/2, i<=n, i)

for j in range (1, j<=n, 2*j)

for k in range (1, k<=n,k * 2)

print (“Hello”)

1
2
3
4
5

## Example 12

def A ():

for i in range (1,  i<=n, 1)

for j in range(1, j<=n, j+i)

print (“Hello”)
1
2
3
4

## Example 13

RJRY
71
def A ():
n= 2

for i in range (1,  i<=n, 1)

j=2

while (j<=n):

j=j*j;

print (“Hello”)
2k
1
2
3
4
5
6
7
