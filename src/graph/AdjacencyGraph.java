package graph;

import java.util.LinkedList;

/**
 * A finite set of vertices also called as nodes.
 * A finite set of ordered pair of the form (u, v) called as edge.
 */
public class AdjacencyGraph {

    public static void main(String[] args) {
        // create the graph given in above figure
        int V = 5;
        AdjacencyGraph ajGraph = new AdjacencyGraph();
        Graph graph = ajGraph.new Graph(V);
        ajGraph.addEdge(graph, 0, 1);
        ajGraph.addEdge(graph, 0, 4);
        ajGraph.addEdge(graph, 1, 2);
        ajGraph.addEdge(graph, 1, 3);
        ajGraph.addEdge(graph, 1, 4);
        ajGraph.addEdge(graph, 2, 3);
        ajGraph.addEdge(graph, 3, 4);

        // print the adjacency list representation of the above graph
        ajGraph.printGraph(graph);
    }

    class Graph {
        int V;
        LinkedList<Integer> ls[];

        Graph(int V) {
            this.V = V;
            ls = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                ls[i] = new LinkedList<>();
            }
        }
    }

    void addEdge(Graph graph, int src, int dest) {
        graph.ls[src].addFirst(dest); // add edges
        graph.ls[dest].addFirst(src); // add unidirection

    }

    void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex: " + v);
            for (Integer i : graph.ls[v]) {
                System.out.print(" ->" + i);
            }
            System.out.println();
        }
    }
}
