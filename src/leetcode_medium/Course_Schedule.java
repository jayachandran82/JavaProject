package leetcode_medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * https://www.youtube.com/watch?v=EgI5nU9etnU&ab_channel=NeetCode
 * <p>
 * Time Complexity: O(m + n )
 * Space Complexity: O(m + n )
 */
public class Course_Schedule {
    // topological sorting

    // Step 1: Create adjacency list and in-degree array
    // Step 2: Populate adjacency list and in-degree array
    // Step 3: Initialize a queue with courses having no prerequisites
    // Step 4: Perform topological sorting

    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create a graph represented by an adjacency list where each course points to its prerequisites
        List<List<Integer>> adj = new ArrayList<>();


        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // Create an array to store the in-degree (number of prerequisites) for each course
        int[] inDepth = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(prereq).add(course);
            inDepth[course]++;
        }

        // Queue to hold courses with in-degree of 0 (no prerequisites)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDepth[i] == 0) {
                queue.offer(i);
            }
        }
        // Counter for number of courses that have been processed
        int count = 0;

        // Process the courses in the queue
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            // Iterate over the neighbors of the current course
            for (int prereq : adj.get(current)) {
                // Decrement the in-degree of each neighbor, since we have processed one of their prerequisites
                inDepth[prereq]--;
                if (inDepth[prereq] == 0) {
                    // If in-degree becomes 0, it means all prerequisites are met, so enqueue the course
                    queue.offer(prereq);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        //System.out.println("Course Schedule : " + canFinish(2, new int[][]{{1, 0}})); // Output: true
        System.out.println("Course Schedule : " + canFinish(2, new int[][]{{1, 0}, {0, 1}})); // Output: false (Cycle detected)
        //System.out.println("Course Schedule : " + canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})); // Output: false (Cycle detected)
    }
}
