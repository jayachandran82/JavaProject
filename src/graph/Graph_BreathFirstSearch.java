package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph_BreathFirstSearch {
    int V;
    ArrayList<Integer> adj[];

    Graph_BreathFirstSearch(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void edege(int x, int y) {
        adj[x].add(y);
    }

    void breathFirstSearch(int sourceVertex) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> a1 = new ArrayList<>();
        visited[sourceVertex] = true;
        a1.add(sourceVertex);
        while (!a1.isEmpty()) {
            sourceVertex = a1.remove(0);
            System.out.println(sourceVertex + " ");
            Iterator i = adj[sourceVertex].iterator();
            while (i.hasNext()) {
                int n = (int) i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    a1.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph_BreathFirstSearch graph = new Graph_BreathFirstSearch(6);
        graph.edege(0, 1);
        graph.edege(0, 2);
        graph.edege(0, 5);
        graph.edege(1, 0);
        graph.edege(1, 2);
        graph.edege(5, 0);
        graph.edege(4, 5);
        graph.edege(4, 2);
        graph.edege(3, 2);
        graph.edege(3, 4);
        graph.breathFirstSearch(0);
    }
}
