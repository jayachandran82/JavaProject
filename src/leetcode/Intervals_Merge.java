package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * https://www.youtube.com/watch?v=dzNIPX7HY6A&ab_channel=NikhilLohia
 * Time Complexity : O(n log(n))
 * Space Complexity : O(n)
 */
public class Intervals_Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Intervals_Merge obj = new Intervals_Merge();
        int[][] result = obj.merge(intervals);
        System.out.println("Final Result : " + Arrays.deepToString(result));

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

        ArrayList<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] intervel : intervals) {
            if (intervel[0] <= newInterval[1]) {
                // Overlapping intervals, update the end if needed
                newInterval[1] = Math.max(intervel[1], newInterval[1]);
            } else {
                newInterval = intervel;
                result.add(newInterval);

            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
