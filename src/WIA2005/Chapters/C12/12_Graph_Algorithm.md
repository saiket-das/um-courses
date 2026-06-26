# Chapter 12: Graph Algorithms

```
WIA2005: Algorithm Design 
and Analysis
Lecture 11: Graph Algorithm
Asmiza A. Sani
Semester 2, Session 2025/26
```

## Definition of Graph Algorithm

- A graph algorithm is a step-by-step procedure used to solve problems related
to graph data structures, where a graph is a collection of nodes (vertices)
connected by edges (links).
- These algorithms enable efficient operations such as traversing, searching, or
optimising paths and flows within a graph.
- Common graph algorithms include:
- Graph Traversal Algorithms: BFS, DFS
- Shortest Path Algorithms: Dijkstra’s, Bellman-Ford
- Minimum Spanning Tree Algorithms: Kruskal’s, Prim’s

## Real World Example of Graph Algorithm

- Graph algorithms play a critical role in solving complex, real-world problems
across various domains:
Transportation and
Navigation
Social Networks
Telecommunications
Supply Chain and
Logistics
Biology and
Chemistry
Computer
Networking

## Terminology

- A graph G = (V, E) consists of a set of vertices V, and a set of edges E,
such that each edge in E is a connection between a pair of vertices in
V.
- The number of vertices is written |V|, and the number edges is written
|E|.
- Two vertices are called neighbors if they are adjacent to one another
and joined by an edge.
- An edge connecting vertices u and v is written (u,v)
- It is said to be incident on vertices u and v
- Can also associate each edge with cost or weight

## Types of Graph

- There are several types of graph, including:
- Directed
- Undirected
- Weighted
- Bipartite

## Graphs Representation

a)
Edges not directed: undirected graph
b)
Edges directed from one vertex to another: directed graph
c)
Labels associated with its edges and vertices: labeled graph or weighted graph
d)
Set of vertices can be divided into two distinct groups, U and V , such that:
- Every edge connects a vertex from group U to a vertex from group V .
- No edges exist between vertices within the same group.
(d)

## Connected Components

- An undirected graph is connected if there is at least one path from any vertex
to any other.
- The maximum connected subgraphs of an undirected graph are called
connected components.

## Directed Representation

(a) Directed graph
(b) Adjacency matrix
(c) Adjacency list

## Undirected Representation

(a) Undirected graph
(b) Adjacency matrix
(c) Adjacency list

## Representation Costs

- Adjacency Matrix: Space -  (|V2|)
- since it requires space for each potential edge
- Adjacency List: Space - (|V|+|E|)
- since there must be an array entry for each vertex and each edge must at least appear in
one of the vertex

## Acyclic Graph

- Acyclic Graph: a graph without cycles
- A directed graph without cycles is called a directed acyclic graph or DAG
- A free tree is a connected, undirected graph with no simple cycle: connected
with |V|-1 edges

## Graph Traversal Algorithms

## Graph Traversal Techniques

- Graph traversal refers to visiting all the nodes (vertices) of a graph in a
systematic manner.
- The two primary graph traversal techniques are:
- Breadth-First Search (BFS)
- Depth-First Search (DFS)

## BFS vs DFS

Feature
BFS
DFS
Main idea
Explore level by level
Go deep, then backtrack
Data structure
Queue
Stack / recursion
Best for
Unweighted shortest path, levels
Cycle detection, topological sort
Not good for
Weighted shortest path
Shortest path
Time complexity
Θ(V + E)
Θ(V + E)

## Breadth First Search

- BFS explores the graph level by level,
starting from a source node. It visits all
neighbors of a node before moving to the
next level.
- Using queue.
- Key Characteristics:
- Suitable for unweighted graphs to find the
shortest path.
- Uses a queue data structure (FIFO).
- Traverses nodes layer by layer.

## Breadth First Search

Cost: (|V| + |E|).

## Depth First Search

- DFS explores as far as possible along each
branch before backtracking.
- Using stack.
- Key Characteristics:
- Suitable for tasks like detecting cycles or ordering
nodes.
- Uses a stack data structure (LIFO) or recursion.
- Traverses nodes depth-first.

## Depth First Search

Cost: (|V| + |E|).

## Applications of BFS and DFS

- Some example application of BFS and DFS includes:
- BFS for Shortest Path in Unweighted Graphs
- BFS ensures the shortest path in terms of the number of edges in an unweighted graph.
- Example:
- Consider a grid-like graph where nodes represent intersections, and edges represent roads. BFS can
find the shortest path between two intersections.
- DFS for Cycle Detection
- DFS is useful for detecting cycles in directed graphs.
- During traversal, if a node is visited again before finishing its recursion, a cycle exists.
- DFS for Topological Sorting
- Topological sorting is an ordering of nodes in a Directed Acyclic Graph (DAG) such that for every
directed edge  u → v , u appears before v .

## Topological Sorting

- A topological sort is a linear ordering in a directed acyclic graph
such that every directed edge (u, v), vertex u comes before v in the
ordering.

## Topological Sort

A
B
C
E
F
G
A
B
C
E
F
G

## Elementary - Topological Sort

The following is a simple algorithm for
topologically sorts:
1.
Call DFS(G) to compute finishing
times v.f for each vertex
2.
As each vertex is finished, insert it
onto the front of a linked list.
3.
Return the linked list of vertices.

## Minimum Spanning Tree

Algorithms

## Minimum Spanning Tree

- Since T is acyclic and connects all of the vertices, it must form a tree, which we
call a spanning tree since it “spans” the graph G.
- We call the problem of determining the tree T the minimum-spanning-tree
problem.

## Growing a minimum spanning tree

- Assume that we have a connected, undirected graph G=(V, E) with a weight
function w: E -> R, and we wish to find a minimum spanning tree for G.
- The two algorithms we consider use a greedy approach to the problem,
although they differ in how they apply this approach.

## Greedy Algorithm for MST

- This greedy strategy is captured by the following generic method, which grows
the minimum spanning tree one edge at a time.
- The generic method manages a set of edges A, maintaining the following loop
invariant:
- Prior to each iteration, A is a subset of some minimum spanning tree.
- At each step, we determine an edge (u,v) that we can add to A without violating
this invariant, in the sense that A U {(u,v)} is also a subset of a minimum
spanning tree.
- We call such an edge a safe edge for A, since we can add it safely to A while
maintaining the invariant.

## The algorithms of Kruskal and Prim

- The two minimum-spanning-tree algorithms described here elaborate on the
generic method.
- They each use a specific rule to determine a safe edge.
- In Kruskal’s algorithm, the set A is a forest whose vertices are all those of the
given graph. The safe edge added to A is always a least-weight edge in the
graph that connects two distinct components.
- In Prim’s algorithm, the set A forms a single tree. The safe edge added to A is
always a least-weight edge connecting the tree to a vertex not in the tree.

## Kruskal’s algorithm

- Kruskal’s algorithm finds a safe edge to add to the growing forest by finding, of
all the edges that connect any two trees in the forest, an edge (u,v) of least
weight.
- It uses a disjoint-set data structure to maintain several disjoint sets of
elements.
- Each set contains the vertices in one tree of the current forest. The operation
FIND-SET(u) returns a representative element from the set that contains u.
- To determine whether two vertices u and v belong to the same tree by testing whether
FIND-SET(u) equals FIND-SET(v).
- To combine trees, Kruskal’s algorithm calls the UNION procedure.

## Kruskal’s algorithm

- Pseudocode

## Line 2

MAKE-SET for Each Vertex:
MAKE-SET(A)
Initialize A such that A.parent = A
MAKE-SET(B)
Initialize B such that B.parent = B
MAKE-SET(C)
Initialize C such that C.parent = C
At this point, each vertex is its own set. Visually, it can be represented as:
A → A
B → B
C → C
The Psedocode:
MAKE-SET(v):
v.parent = v    # Point v to itself, making it the root of its set
v.rank = 0      # Optional, used in some implementations to keep the
tree flat
A
B
C
3
2
1
Root

## Line 4 - 8

Processing Edges in Ascending Order of Weights:
Step 1: Edge (A, C, 1)
Lowest weight edge first.
FIND-SET(A) returns A.
FIND-SET(C) returns C.
Since A and C are in different sets, UNION(A, C) is performed:
Set C.parent = A.
State after operation:
A → A
B → B
C → A

## Line 4 - 8

Step 2: Edge (B, C, 2)
Next lowest weight edge.
FIND-SET(B) returns B.
FIND-SET(C) now returns A because C's parent has been updated to A.
Since B and C (A) are in different sets, UNION(B, C) is performed:
Continue using A as the root and set B.parent = A.
State after operation:
A → A
B → A
C → A

## Line 4 - 8

Step 3: Edge (A, B, 3)
Highest weight edge last.
FIND-SET(A) returns A.
FIND-SET(B) also returns A because B's parent has been updated to A.
Since A and B are already in the same set, adding this edge would create a cycle, so do not
perform UNION. This edge is redundant in terms of firebreak strategy because A and B are
already connected.
Final State and Analysis:
The graph is fully connected under one root, A, effectively showing all regions are within a
single set, indicating a unified strategy against fire spread:
A → A
B → A
C → A

## Kruskal’s algorithm

## Running time of Kruskal’s algorithm

- The running time of Kruskal’s algorithm for a graph G=(V,E) depends on how
we implement the disjoint-set data structure.
- The running time of Kruskal’s algorithm as O(E log V).

## Prim’s algorithm

- Prim’s algorithm operates much like Dijkstra’s algorithm for finding shortest
paths in a graph.
- Prim’s algorithm has the property that the edges in the set A always form a
single tree.
- The tree starts from an arbitrary root vertex r and grows until the tree spans all
the vertices in V .
- Each step adds to the tree A a light edge that connects A to an isolated
vertex—one on which no edge of A is incident.
- This strategy qualifies as greedy since at each step it adds to the tree an edge
that contributes the minimum amount possible to the tree’s weight.

## Prim’s algorithm

- In order to implement Prim’s algorithm efficiently, we need a fast way to select
a new edge to add to the tree formed by the edges in A.
- In the pseudocode below, the connected graph G and the root r of the
minimum spanning tree to be grown are inputs to the algorithm.
- During execution of the algorithm, all vertices that are not in the tree reside in
a min-priority queue Q based on a key attribute.
- For each vertex v, the attribute v.key is the minimum weight of any edge
connecting v to a vertex in the tree; by convention, v.key = ∞ if there is no such
edge.
- The attribute v: π names the parent of v in the tree.

## Prim’s algorithm

Pseudocode
- The algorithm implicitly maintains
the set A from GENERIC-MST as
- When the algorithm terminates, the
min-priority queue Q is empty; the
minimum spanning tree A for G is
thus

## Prim’s

algorithm

## Shortest Path Algorithms

## Shortest Paths Problems

- Shortest path problems are an optimization problem that can be solve using
greedy or dynamic programing approach.
- The input to this problem is a graph with weights or costs associated with each
edge.
- The output will be the list of edges forming the shortest path.
- Sample problems:
- Find shortest path between two named vertices
- Find shortest path from S to all other vertices
- Find shortest path between all pairs of vertices
- Will actually calculate only distances.

## Relaxation

- Most shortest-path algorithms use relaxation.
- For each vertex ∈ V , we maintain an attribute v.d (shortest path estimate),
which is an upper bound on the weight of a shortest path from source s to v.
- The process of relaxing an edge (u, v) consists of testing whether we can
improve the shortest path found so far by going through u and, if so, updating
d.v and d.π.

## Dijkstra’s Algorithm

- Dijkstra’s algorithm solves the single-source shortest-paths problem on a
weighted, directed graph G = (V, E) for the case in which all edge weights are
nonnegative.
O(|V|2)

## Dijkstra’s Algorithm

## Dijkstra’s Algorithm

Selected
vertex
s
t
x
y
z
Initial s
0




Process y
0
10

5

Process z
0
8
14
5
7
Process t
0
8
13
5
7
Process x
0
8
9
5
7
Updating the
distance using table

## Bellman-Ford Algorithm

- The Bellman-Ford algorithm solves the single-source shortest-paths problem in
the general case in which edge weights may be negative.
- Given a weighted, directed graph G = (V, E) with source s and weight function w
: E → ℝ, the Bellman-Ford algorithm returns a boolean value indicating
whether or not there is a negative-weight cycle that is reachable from the
source.
- If there is such a cycle, the algorithm indicates that no solution exists.
- If there is no such cycle, the algorithm produces the shortest paths and their weights.

## Bellman-Ford Algorithm

O(VE)

## All-pairs shortest-paths

- All-pairs shortest-paths is the problem of finding shortest paths between all
pairs of vertices in a graph.
- Given a weighted, directed graph G = (V, E) with a weight function w w : E → ℝ,
that maps edges to real-valued weights.
- We wish to find, for every pair of vertices u, v ∈ V , a shortest (least-weight) path from u to
v, where the weight of a path is the sum of the weights of its constituent edges.
- We typically want the output in tabular form: the entry in u’s row and ’s column should be
the weight of a shortest path from u to .
- We can solve an all-pairs shortest-paths problem by running a single-source
shortest-paths algorithm |V| times, once for each vertex as the source.

## Floyd-Warshall Algorithm

- In the Floyd-Warshall algorithm, we use a different approach (dynamic-
programming formulation) to solve the all-pairs shortest-paths problem on a
directed graph G – (V, E).

## Floyd-Warshall’s Algorithm

## All-Pairs Shortest Path -

Johnson Algorithm
Extra

## All-Pairs Shortest Paths - Johnson Algorithm

Johnson's algorithm has three main steps:
1. A new vertex is added to the graph, and it is
connected by edges of zero weight to all other
vertices in the graph.
2. All edges go through a reweighting process
that eliminates negative weight edges.
3. The added vertex from step 1 is removed and
Dijkstra's algorithm is run on every node in
the graph.

## All-Pairs Shortest Paths - Johnson Algorithm

## How do we choose which algorithm to use?

Ask this question
Use this
Do I need to visit/search nodes?
BFS / DFS
Do I need dependency order?
Topological Sort
Do I need to connect all nodes cheaply?
Prim / Kruskal
Do I need shortest path from one source?
Dijkstra / Bellman-Ford
Do I need shortest path between all pairs?
Floyd-Warshall

## In the next lecture.. Wait.. We are done!!
