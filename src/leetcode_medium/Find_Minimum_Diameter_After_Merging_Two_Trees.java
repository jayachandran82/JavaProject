package leetcode_medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.
 * You must connect one node from the first tree with another node from the second tree with an edge.
 * Return the minimum possible diameter of the resulting tree.
 * The diameter of a tree is the length of the longest path between any two nodes in the tree.
 * <p>
 * Example:
 * Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
 * Output: 3
 * Time Complexity: O(n+m)
 * Total Space Complexity: O(n+m)
 * ==> Visited Array: O(n) for the first tree and O(m) for the second tree.
 * ==> Queue: At most O(n) for the first tree and O(m) for the second tree.
 * ==> BFS Queue:  O(n+m)
 */
public class Find_Minimum_Diameter_After_Merging_Two_Trees {
    private static int findMinimumDiameter(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        int diameter1 = findTreeDiameter(n, tree1);
        int diameter2 = findTreeDiameter(m, tree2);

        return Math.max(diameter1, Math.max(diameter2, (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1));
    }

    static List<List<Integer>> buildTree(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    static int findTreeDiameter(int n, List<List<Integer>> tree) {

        int[] farthest = bfs(tree, 0, n);
        int[] farthestFromFarthest = bfs(tree, farthest[0], n);

        return farthestFromFarthest[1];
    }

    static int[] bfs(List<List<Integer>> tree, int start, int nodes) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[nodes];
        boolean[] visited = new boolean[nodes];
        visited[start] = true;
        queue.add(start);
        int farthestNode = start, maxDistance = 0;

        while (!queue.isEmpty()) {
            int nodeVal = queue.poll();
            for (int neighbor : tree.get(nodeVal)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[nodeVal] + 1;
                    queue.add(neighbor);
                    if (distance[neighbor] > maxDistance) {
                        maxDistance = distance[neighbor];
                        farthestNode = neighbor;
                    }
                }
            }
        }
        return new int[]{farthestNode, maxDistance};
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}};
        int[][] edges2 = {{0, 1}};
        int result = findMinimumDiameter(edges1, edges2);
        System.out.println("Find Minimum Diameter After Merging Two Trees :  " + result);
    }
}
