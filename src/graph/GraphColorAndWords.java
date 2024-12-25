package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GraphColorAndWords {

	public static void main(String[] args) {

		GraphColorAndWords obj = new GraphColorAndWords();
		Graph g = obj.new Graph();
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");
		g.addNode("E");
		g.addNode("F");
		g.addNode("G");

		g.nodeColor("A", "GREEN");
		g.nodeColor("B", "GREEN");
		g.nodeColor("C", "RED");
		g.nodeColor("D", "RED");
		g.nodeColor("E", "GREEN");
		g.nodeColor("F", "RED");
		g.nodeColor("G", "RED");

		g.addEdge("B", "A");
		g.addEdge("B", "D");
		g.addEdge("C", "B");
		g.addEdge("D", "E");
		g.addEdge("F", "E");
		g.addEdge("G", "F");

		obj.printGraph(g);
		obj.printNodesColor(g);
		obj.removeRedNode(g);
	}

	public void printGraph(Graph graph) {
		Iterator<?> it = graph.nodes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println("Node : " + pair.getKey());
			Set<String> set = (Set<String>) pair.getValue();
			for (String s : set) {
				if (!s.isEmpty()) {
					System.out.println("  Edges =>" + s);
				}
			}
		}
	}

	public void printNodesColor(Graph graph) {
		Iterator<?> it = graph.nodesColor.entrySet().iterator();
		System.out.println("\n ********************** \nNode : Color");
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " => " + pair.getValue());
		}
	}

	public void removeRedNode(Graph graph) {
		Iterator<?> nodecolor = graph.nodesColor.entrySet().iterator();
		Iterator<?> edges = graph.nodes.entrySet().iterator();

		while (nodecolor.hasNext()) {
			Map.Entry color = (Map.Entry) nodecolor.next();
			String colorKey = (String) color.getKey();

			if (color.getValue().equals("GREEN")) {
				// System.out.println(" vertex ==>>>>>>>> "+vertex);
				System.out.println(" color value : " + color.getKey() + "=> " + color.getValue());

				validateColor(colorKey, graph.nodes);
			}
		}

	}

	/**
	 * 
	 * @param colorKey C => GREEN
	 * @param nodeEdges "C":"B"  
	 */
	public void validateColor(String colorKey,  HashMap<String, HashSet<String>> nodes) {
		System.out.println("Step :::::");
		System.out.println("Key :::" +nodes.get(colorKey));
/*		while (nodeEdges.hasNext()) {
			Map.Entry nodePair = (Map.Entry) nodeEdges.next();
			if (colorKey.equals(nodePair.getKey())) {
				System.out.println(" vertex  && node  ==>>>>>>>> " + colorKey);
				Set<String> edges = (Set<String>) nodePair.getValue();
				for (String edge : edges) {
					if (!edge.isEmpty()) {
						System.out.println("  Edges =>" + edge);
					}
				}
			}

		}*/
	}

	class Graph {
		private HashMap<String, HashSet<String>> nodes;
		Map<String, String> nodesColor = new HashMap<>();

		public Graph() {
			nodes = new HashMap<String, HashSet<String>>();
		}

		public void addNode(String name) {
			Set<String> node = nodes.get(name);
			if (node != null)
				throw new RuntimeException("addNode - node already exist");
			nodes.put(name, new HashSet<String>());
		}

		public void addEdge(String src, String dest) {
			HashSet<String> adjList = nodes.get(src);

			if (adjList == null)
				throw new RuntimeException("addEdge - src node does not exist");

			adjList.add(dest);
		}

		/**
		 * Returns true if a node with the given name was added.
		 */
		public boolean hasNode(String name) {
			return nodes.containsKey(name);
		}

		// Function to assign colors to vertices of graph
		public void nodeColor(String node, String color) {
			// stores color assigned to each vertex
			nodesColor.put(node, color);

		}

	}

}
