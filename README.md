## README

###  Dijkstra Shortest Path Algorithm

This program implements the Dijkstra Shortest Path algorithm for finding the shortest path between two vertices in an undirected graph.

### Input and Output Format

- **Input Format:** 
  - The input consists of:
    1. The number of nodes and number of edges separated by a space.
    2. Space-separated names of nodes.
    3. One edge per line in the format "A-B weight", where A and B are vertices and weight is the edge weight.
    4. The source vertex followed by a space and then the destination vertex.

- **Output Format:** 
  - The output is:
    1. The shortest path from source to destination, with each vertex separated by '-'.
    2. The cost of the path.

**Example:**

- **Input:** 
  ```
  4 5
  A B C D
  A-B 5
  A-C 8
  B-C 9
  B-D 2
  C-D 6
  A D
  ```

- **Output:** 
  ```
  A-B-D
  7
  ```



### Notes

- Ensure that the input follows the specified format.
- The program uses adjacency list representation for the graph.
- It implements the Dijkstra algorithm to find the shortest path from source to destination.
- In case of multiple shortest paths, only one of these paths is returned.
- "Main" class is the entry point into program
