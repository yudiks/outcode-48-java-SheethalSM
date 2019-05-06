# Where do you expect to be in five years?

Should take one minute; minute and a half at most

##### Prompt

Say: "Where do you expect to be in five years?"  

##### Do you hear these things?

- *Identify*: Does the interviewee discuss their competencies based on what you have asked them? Competencies include:
   - Technical Skills (libraries, languages, etc.)
   - Interpersonal Skills  


- *Prove*: Does the interviewee provide a _specific_ example (past experience or hypothetical scenario)  to showcase competencies and/or fit? Is it presented in the form of a story (punchline, beginning, middle, positive end)?


- *Close*: Does the interviewee showcase why the company should hire them and how their skills/experience/values will add value to and align with the team/company? Does the interviewee showcase what they have learned in "Prove" and how they will apply it to the new role?

# 320 - Shortest Route

Given an unweighted, undirected graph which represents a metro map as follows

* vertices are stations
* edges are the path between two stations


Given a start station and ending station, determine the minimum number of stops that must be made to get to the destination.

```
Input: A Graph (unweighted/undirected), a starting Vertex, and an ending Vertex
Output: Integer
```
# Example
```
Input: The graph represented below, Vertex A, Vertex F
```
![Shortest Route](http://res.cloudinary.com/outco-io/image/upload/v1520909723/ShortestRoute.png)
```
Output: 2 Stops (From A stop at C, and then stop at F)
```

# Constraints

```
Time Complexity: O(V + E) where V is the number of Vertices and E is the number of Edges
Auxiliary Space Complexity: O(V)
```

A graph `Vertex` instance has the following properties:
* `value` : a string
*	`edges` : a list which contains references to other vertices in the Graph

The graph has a list of all the vertices: `Graph.vertices`

The `Vertex` values are all unique

# Solution

### Approach #1

Perform a BFS from the starting node:

* 1) Create a `distance` hashtable.

  * a) Store each vertex value as the key, and a distance of `INFINITY`

  * b) Set the `start` vertex value to `0`

* 2) Create a `visited` hashtable

  * a) Store each vertex value as the key and a visited to false


* 3) Instantiate a queue and place the starting vertex in the queue

* 4) While there is something in the queue

  * a) Dequeue the `current` vertex and mark it as visited.

  * b) For each edge, if the associated `neighbor` has not been visited

    * i) Update the neighbor’s `distance` as the minimum of:

      * 1) the distance of `neighbor`

      * 2) the distance of the `current + 1`

    * ii) Add the neighbor to the queue

* 5) Return the distance of `end` vertex

### Approach #2

Perform BFS from the starting node:

1. Instantiate a queue and a `visited` set data structure

2. Enqueue a tuple (can be array or class data structure) inside
   the queue. The tuple will consist of two elements:

    * Initial starting node

    * Distance from the initial starting node; this will be set to `0`
      initially as the starting node is zero steps away from itself

3. Add initial starting node to `visited` set.

4. Create a while loop that will run as long as there are elements in the queue

    * Dequeue from the queue to grab the:

        * current node

        * current distance from starting node

    * If current node is equal to the target node, return the current distance.
      This current distance is now the solution

    * Otherwise, iterate through each of that node's edges

        * If the edge has not be visited yet (does not exist inside `visited`),
          enqueue a tuple containing that edge and a distance from the starting
          node of the current distance plus one.

# Resources

[Shortest Route on Hackerrank](https://www.hackerrank.com/challenges/bfsshortreach)

[BFS Graph Traversal on Geeks for Geeks](http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/)
