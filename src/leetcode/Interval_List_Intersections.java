package leetcode;

import java.util.ArrayList;

/**
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
 * and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * <p>
 * The intersection of two closed intervals is a set of real numbers that are either empty or
 * represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 * <p>
 * <p>
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 */
public class Interval_List_Intersections {
    public static void main(String[] args) {
        Interval_List_Intersections obj = new Interval_List_Intersections();
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] result = obj.intervalIntersection(firstList, secondList);

        System.out.println("Intersection Intervals:");
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0 || firstList == null || secondList == null) {
            return new int[0][];
        }

        int i = 0, j = 0;
        ArrayList<int[]> result = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int max = Math.max(firstList[i][0], secondList[j][0]);
            int min = Math.min(firstList[i][1], secondList[j][1]);
            if (max <= min) {
                result.add(new int[]{max, min});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
