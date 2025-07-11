package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlippingSwitchesOnOff {
    private static int finalState(List<List<Integer>> operations) {
        int maxIndex = 0;


        // Find the maximum index to minimize array size
        for (List<Integer> operation : operations) {
            maxIndex = Integer.max(operation.get(1), maxIndex);
        }

        // Initialize difference array up to maxIndex + 2
        int flip[] = new int[maxIndex + 2];
        for (List<Integer> operation : operations) {
            int left = operation.get(0);
            int right = operation.get(1);
            flip[left] += 1;
            flip[right + 1] -= 1;

        }
        int currentFlip = 0, result = 0;
        //  Calculate Final State and Sum Indices
        //  currentFlip keeps track of how many times the current switch has been flipped (using prefix sum).
        //  If it’s odd, then switch is ON, so we add its index to the result.
        for (int i = 1; i <= maxIndex; i++) {
            currentFlip += flip[i];
            if (currentFlip % 2 == 1) {
                result += i; // switch is ON
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample input: [[4,5],[1,4],[2,6],[1,5]]
        List<List<Integer>> operations = new ArrayList<>();
        operations.add(Arrays.asList(4, 5));
        operations.add(Arrays.asList(1, 4));
        operations.add(Arrays.asList(2, 6));
        operations.add(Arrays.asList(1, 5));

        // Call the function and print result
        int result = finalState(operations);
        System.out.println(result);  // Expected: 16

    }
}
