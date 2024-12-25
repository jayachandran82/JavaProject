package graph;

import java.util.*;

public class BreadthFirstSearch_Queue {
    private HashMap<Integer, List<Integer>> adjacencyList;

    BreadthFirstSearch_Queue() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    void addVertex(int vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void breathFirstSearch(int vertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited.add(vertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for(int adjacency : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())){

                if(!visited.contains(adjacency)){
                    queue.add(adjacency);
                    visited.add(adjacency);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
