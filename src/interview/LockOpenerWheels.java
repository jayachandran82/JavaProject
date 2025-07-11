package interview;


import java.util.*;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', ..., '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', representing the state of the 4 wheels. Given a target representing the value of the
 * wheels that will unlock the lock, return the minimum total number of turns required to open the lock.
 */
public class LockOpenerWheels {

    private static int openLock(String target) {
        if ("0000".equals(target)) return 0;

        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add("0000");
        endSet.add(target);
        visited.add("0000");

        int level = 0;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set for optimization
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String current : beginSet) {
                for (String neighbor : getNeighbors(current)) {
                    if (endSet.contains(neighbor)) {
                        return level + 1;
                    }
                    if (visited.add(neighbor)) {
                        nextLevel.add(neighbor);
                    }
                }
            }

            beginSet = nextLevel;
            level++;
        }

        return -1; // target is unreachable
    }

    static private List<String> getNeighbors(String state) {
        List<String> result = new ArrayList<>();
        char[] chars = state.toCharArray();

        for (int i = 0; i < 4; i++) {
            char c = chars[i];

            // Rotate forward
            chars[i] = c == '9' ? '0' : (char) (c + 1);
            result.add(new String(chars));

            // Rotate backward
            chars[i] = c == '0' ? '9' : (char) (c - 1);
            result.add(new String(chars));

            // Restore original
            chars[i] = c;
        }

        return result;
    }

    public static void main(String[] args) {

        String targetCombination = "3456";
        System.out.println("Minimum moves: " + openLock(targetCombination));  // Output: 6
    }


}