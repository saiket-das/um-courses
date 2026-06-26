# Chapter 4: String Matching

```
WIA2005: Algorithm Design 
and Analysis
Lecture 4: String Matching (Asynchronous)
Asmiza A. Sani
Semester 1, Session 2024/25
```

## Learning objectives

- Know string matching algorithm
- Understand the string-matching problem and its relevance.
- Explain and implement Naïve, Finite-automaton, Knuth-Morris-Pratt (KMP), and Rabin-
Karp algorithms.
- Analyse the time and space complexity of each algorithm.
- Apply appropriate algorithms to real-world problems.
- Extra: Tries

## Introduction

- Text-editing programs frequently
need to find all pattern occurrences
in the text.
- Typically, the text is a document
being edited, and the pattern
searched for is a particular word
supplied by the user.
- Efficient algorithms for this
problem—“string matching”—can
greatly improve the responsiveness
of the text-editing program.
Search for particular patterns in DNA
sequences.
Internet search engines also use them to
find web pages that are relevant to queries.
Among their many other
applications string-matching
algorithms

## String matching problem

- String-matching problems are formalized as follows:
- Assume that the text is an array T[1..n] of length n and that the pattern is an array P[1..m]
of length m ≤ n.
- Further assume that the elements of P and T are characters drawn from a finite alphabet
Σ.
- For example, we may have Σ = {0,1} or Σ = {a, b, c, .., z}.
- The character arrays P and T are often called strings of characters.

## Asynchronous Lecture Instruction

- Whenever there is a link on the top of the slides (Highlighted yellow), please
watch the video provided first.
- Then go through the rest of the slides.

## Naïve (Brute-force) string-matching algorithm

- An example of the string-matching problem, where we want to find all
occurrences of the pattern P = abaa in the text T = abcabaabcabac.
- The pattern occurs only once in the text, at shift s = 3, which we call a valid
shift.
- A vertical line connects each character of the pattern to its matching character
in the text, and all matched characters are shaded.
https://youtu.be/yKhPWrdA6U8?si=nxXqZnSeUqmPKBoP

## Naive string-matching pseudocode

- The naive algorithm finds all valid shifts using a
loop that checks the condition P = [1..m] =  T[s
+ 1… s +m] for each of the n – m + 1 possible
values of s. No preprocessing phase.
- Constant extra space needed;
- Always shifts the window by exactly 1 position to
the right;
- Comparisons can be done in any order;
- Searching phase in O(mn) time complexity;
- 2n expected text characters comparisons.

## String matching with finite automata

- Many string-matching algorithms build a finite automaton—a simple machine
for processing information—that scans the text string T for all occurrences of
the pattern P.
- These string-matching automata are very efficient: they examine each text
character exactly once, taking constant time per text character.
- especially for regular expressions used in compiler (parser)
https://youtu.be/5KJtYMjeY4U?si=QzQhY8Vs75aP2mKG

## Finite automata

- A finite automaton (plural of automata) M, is a 5-tuple (Q, q0, Α, Σ, δ) where:
For example, on input abaaa,
including the start state, this
automaton enters the sequence of
states <0, 1, 0, 1, 0, 1>, and so it
accepts this input.
For input abbaa, it enters the
sequence of states <0, 1, 0, 0, 1, 0>,
and so it rejects this input.

## String matching automata

- For a given pattern P , we
construct a string-matching
automaton in a preprocessing
step before using it to search the
text string.
- In order to specify the string-
matching automaton
corresponding to a given pattern
P[1..m] we first define an auxiliary
function σ, called the suffix
function corresponding to P.

## Finite-automaton string-matching pseudocode

## Rabin-Karp algorithm

- Rabin and Karp proposed a
string-matching algorithm that
performs well in practice and that
also generalizes to other
algorithms for related problems,
such as two-dimensional pattern
matching.
- Using hash (Rolling hash)
- The Rabin-Karp algorithm uses
O(m) preprocessing time, and its
worst-case running time is O((n-
m+1)m)
https://youtu.be/yFHV7weZ_as?si=2bzdiV_pwxkLNTVm

## Rabin-Karp Pseudocode

## Knuth-Morris-Pratt (KMP) algorithm

- Unlike the naïve approach (which can re-check characters unnecessarily), KMP
uses information about the pattern to skip unnecessary comparisons, making
it faster in the worst case.
- When a mismatch occurs, instead of shifting the pattern by one character (like
the naïve method), KMP uses a precomputed table (called the LPS array) to
know how far to shift the pattern, based on what is already known.
- Preprocessing time takes O(m), where m is the length of the pattern.
- Searching time takes O(n), where n is the length of the text.
- Overall running time complexity is O(n + m)
https://youtu.be/q4_90fOoS-s?si=4QegDtr07hFVcvoV

## Prefix table (LPS Array)

- Complete prefix function for the pattern ababaca:

## Prefix function for a pattern

- The prefix function π for a
pattern encapsulates
knowledge about how the
pattern matches against
shifts of itself.
- We can take advantage of
this information to avoid
testing useless shifts in the
naive pattern-matching
algorithm and to avoid pre-
computing the full transition
function δ for a string-
matching automaton.

## KMP psudocode

- The pseudocode below gives the Knuth-Morris-Pratt matching algorithm as the
procedure KMP-MATCHER.
- For the most part, the procedure follows from FINITE-AUTOMATON-MATCHER.
- KMP-MATCHER calls the auxiliary procedure COMPUTE-PREFIX-FUNCTION to compute

## Pre-processing and matching time

## Pre-processing text approach

- So far, the previous algorithm are pre-processing patterns.
- Another fast approach to finding text is to pre-process text.
- Text does not change and many search queries.
- Dictionary
- String matching using Trie.

## Extra: Tries

## Tries

- For representing a collection of Strings, such as all the words in a text.
- A tries supports pattern matching queries in time proportional to the pattern
size.
- Properties of a tries:
- A multi-way tree
- Each node has from 1 to n children.
- Each edge of the tree is labelled with a character.
- Each leaf node corresponds to the stored string, which is a concatenation of characters
on a path from the root to this node.
https://youtu.be/zIjfhVPRZCg?si=uWf_NRuu9Px2G1AR

## Types of Tries

## Standard Tries

- The standard trie for a set of strings S is an ordered tree such that:
- Each node but the root is labelled with a character.
- The children of a node are alphabetically ordered.
- The paths from the external nodes to the root yield the strings of S.

## Example of a Standard Tries

## Time/Space complexity of Standard Tries

- A standard trie uses O(n) space and supports searches, insertions and
deletions in time O(dm), where:
- n -  total size of the strings in S
- m - size of the string parameter of the operation
- d - size of the alphabet

## Word matching with a Trie

- We insert the words of the text
into a trie.
- Each leaf stores the occurrences
of the associated word in the text.

## Compressed Trie

- Tries with nodes of degree at least 2.
- Obtained by standard tries by compressing chains of redundant nodes.

## Suffix Tries

- A suffix trie is a compressed trie for all the suffixes of a text.
- Suffix trie are a space-efficient data structure to store a string that allows
many kinds of queries to be answered quickly.

## Analysis of Suffix Tries

- Compact representation of the suffix trie for a string S of size n from an
alphabet of size d
- uses O(n) space.
- supports arbitrary pattern matching queries in S in O(dm) time, where m is the size of the
pattern.
- can be constructed in O(n) time.

## In the next lecture..

Lecture 5: Divide and Conquer Algorithm

## References

- Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein.
2009. Introduction to Algorithms, 3rd edition. MIT Press.
