# ShortestPaths

ShortestPaths.java is an implementation of a classic problem in computer science - finding the shortest path between nodes in a graph. This Java class leverages the power of adjacency matrices to represent the graph and employs a variation of Dijkstra's algorithm to compute the shortest path from a source vertex to all other vertices in the graph.

Features:

Adjacency Matrix Representation: This approach allows for easy and quick access to any edge weight between two vertices in constant time.
Priority Queue-Based Processing: Efficiently retrieves the next closest vertex, ensuring a faster and more optimized solution.
Object-Oriented Principles: Uses a custom Pair class for managing key-value pairs, promoting clean and modular code.
Dynamic Path Tracking: Not only computes the shortest distance but also keeps track of the actual path taken to reach each vertex.
Usage:
Instantiate the ShortestPaths class with a 2D adjacency matrix representing your graph. Call the ComputeShortestPaths method with the source vertex's index to obtain the shortest path and distances to all other vertices.

Example:
int[][] graphMatrix = {
    {0, 1, 4, 0, 0},
    {1, 0, 4, 2, 7},
    {4, 4, 0, 3, 5},
    {0, 2, 3, 0, 4},
    {0, 7, 5, 4, 0}
};
ShortestPaths sp = new ShortestPaths(graphMatrix);
ArrayList<Integer>[] result = sp.ComputeShortestPaths(0);
