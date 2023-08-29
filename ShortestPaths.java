
// Author Holden Brown
package HW5;

import java.util.*;

public class ShortestPaths 
{
	
    private int[][] graph; //adjacency matrix of the graph
    private int vertices; //number of vertices
    
    //constructor
    public ShortestPaths(int[][] g) 
    {
        this.graph = g;
        this.vertices = g.length;
    }
    
    
    //method to compute shortest path from s to all other vertices
    public ArrayList<Integer>[] ComputeShortestPaths(int s) 
    {
        boolean[] visited = new boolean[vertices]; //boolean array for tracking visited
        int[] distances = new int[vertices]; //min distance array from s to other verticies
        ArrayList<Integer>[] paths = new ArrayList[vertices];

        // Initialize distances and paths
        for (int i = 0; i < vertices; i++) {
            distances[i] = Integer.MAX_VALUE; //init distance to max 
            paths[i] = new ArrayList<Integer>(); //paths is empty
        }
        //queue for vertices to visit ordered from shortest to largest
        PriorityQueue<Pair<Integer, ArrayList<Integer>>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        distances[s] = 0;

        // Initialize path for s
        ArrayList<Integer> initPath = new ArrayList<>();
        initPath.add(s);
        pq.add(new Pair<>(0, initPath));

        //while there are nodes in the queue
        while (!pq.isEmpty()) 
        {
            Pair<Integer, ArrayList<Integer>> pair = pq.poll(); //get shortest vertex
            int currentVertex = pair.getValue().get(pair.getValue().size() - 1); //get the last vertex from the path
            
            //if not visited
            if (!visited[currentVertex]) 
            {
                visited[currentVertex] = true;
                
                //go through all vertices in the graph
                for (int i = 0; i < graph.length; i++) 
                {
                    int edge = graph[currentVertex][i]; //mark visited
                    
                    //if there's an edge and the new path distance is less than the known distance
                    if (edge > 0 && ((long) distances[currentVertex] + edge) < distances[i]) 
                    {
                        ArrayList<Integer> newPath = new ArrayList<>(pair.getValue());// create a new path from current path
                        newPath.add(i); //adds new node
                        pq.add(new Pair<>(distances[currentVertex] + edge, newPath));//adds new path to queue
                        distances[i] = distances[currentVertex] + edge;//update shortest path to node
                        paths[i] = newPath;
                    }
                }
            }
        }

        // Convert the distances into ArrayList format and add to the front of paths
        for (int i = 0; i < vertices; i++) 
        {
            if (distances[i] == Integer.MAX_VALUE) 
            {
                paths[i].add(0, -1); //if no path then -1
            } else {
                paths[i].add(0, distances[i]); //else add the path
            }
        }

        return paths;
    }
    
    //pair class for queue elements and other helper methods
    static class Pair<K, V> 
    {
        private K key;
        private V value;
        
        //constructor
        public Pair(K key, V value) 
        {
            this.key = key;
            this.value = value;
        }

        public K getKey() 
        {
            return key;
        }

        public V getValue() 
        {
            return value;
        }
    }
}
