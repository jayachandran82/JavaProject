package interview;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', ..., '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', representing the state of the 4 wheels. Given a target representing the value of the
 * wheels that will unlock the lock, return the minimum total number of turns required to open the lock.
 */
public class LockOpenerWheels {
    public static void main(String[] args) {
        LockOpenerWheels lockOpener = new LockOpenerWheels();
        String targetCombination = "3456";
        System.out.println(lockOpener.openLock(targetCombination));  // Output: 6
    }

    public int openLock(String target) {
        // Initialize the starting position of the lock
        String start = "0000";

        // Create a set to keep track of visited combinations to avoid revisiting them
        Set<String> visited = new HashSet<>();
        visited.add(start);

        // Initialize the queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        // Initialize steps counter
        int steps = 0;

        // Start BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String combination = queue.poll();

                // If the current combination is the target, return the number of steps
                if (combination.equals(target)) {
                    return steps;
                }

                // Explore all possible combinations by rotating each wheel
                for (int j = 0; j < 4; j++) {
                    // Rotate the wheel in the positive direction
                    String newCombinationPos = rotateWheel(combination, j, 1);
                    // Rotate the wheel in the negative direction
                    String newCombinationNeg = rotateWheel(combination, j, -1);

                    // Add the new combinations to the queue if they haven't been visited before
                    if (!visited.contains(newCombinationPos)) {
                        queue.offer(newCombinationPos);
                        visited.add(newCombinationPos);
                    }
                    if (!visited.contains(newCombinationNeg)) {
                        queue.offer(newCombinationNeg);
                        visited.add(newCombinationNeg);
                    }
                }
            }
            steps++; // Increment steps after exploring all combinations at the current level
        }

        // If the target combination is not reachable
        return -1;
    }

    private String rotateWheel(String combination, int wheelIndex, int direction) {
        char[] digits = combination.toCharArray();
        int digit = digits[wheelIndex] - '0';
        // Rotate the wheel in the specified direction
        digit = (digit + direction + 10) % 10;
        digits[wheelIndex] = (char) (digit + '0');
        return new String(digits);
    }
}