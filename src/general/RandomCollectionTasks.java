package general;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * This program generates a random collection of tasks,finds the solution for each task,
 * ranks the solutions and prints the top 50 solutions.
 * 1). LongestOnes
 * 2). LongestPrefix
 * <p>
 * Program will execute the following command parameters.
 * < LongestOnes 8000 12345 LongestPrefix AAGGCCTTAGCTAGCTTTTAAAGGG >
 */
public class RandomCollectionTasks {
    public static void main(String[] args) {
        RandomCollectionTasks obj = new RandomCollectionTasks();

        obj.inputArgValidation(args);
        if ("LongestOnes".equals(args[0])) {
            List<Integer> topList = obj.getLogestOnes(args);
            System.out.println("Display LongestOnes top 50 solutions, Ranked by descending solution length:");
            for (int i = 0; i < topList.size(); i++) {
                System.out.println(" Top " + (i + 1) + " rank value : " + topList.get(i));
            }
        }
        if ("LongestPrefix".equals(args[3])) {
            List<Integer> topList = obj.getLongestPrefix(args);
            System.out.println("Display Longest Prefix top 50 solutions, Ranked by descending solution length:");
            for (int i = 0; i < topList.size(); i++) {
                System.out.println(" Top " + (i + 1) + " rank value : " + topList.get(i));
            }
        }

    }

    public void inputArgValidation(String[] args) {
        try {
            if (!(args.length > 4)) {
                System.out.println("Please pass six arguments in the command line...");

            } else if (!"LongestOnes".equals(args[0]) || !"LongestPrefix".equals(args[3])) {
                throw new IllegalArgumentException("Please check the entered input, it shout be  'LongestOnes' or 'LongestPrefix' ");
            } else if (!"LongestOnes".equals(args[0]) && args.length > 2 && args.length <= 3) {
                int randomGeneratedSeeds = Integer.parseInt(args[1]);
                int nooOfTaskGenerator = Integer.parseInt(args[2]);
            } else if (args[4] != null) {
                boolean flag = true;
                for (int i = 0; i < args[4].length(); i++) {
                    char ch = args[4].charAt(i);
                    if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                        flag = false;
                    }
                }
                if (!flag)
                    throw new IllegalArgumentException("Please enter alphabets characters in the command line 5th argument .....");
            }
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("The input entered is invalid. Please enter integer number");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error Message" + e.getMessage());
        }
    }

    public List<Integer> getLogestOnes(String[] args) {
        List<Integer> topSolutions = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(args[2]); i++) {
            String binaryVector = generateBinaryVector(Integer.parseInt(args[1]));
            int longestOnesLength = findLongestOnesSequence(binaryVector);
            topSolutions.add(longestOnesLength);
        }
        topSolutions.sort((a, b) -> b - a);

        List<Integer> topList = topSolutions.subList(0, Math.min(50, topSolutions.size()));
        return topList;
    }

    public int findLongestOnesSequence(String binaryVector) {
        int n = binaryVector.length();

        int[] longSubSeq = new int[n];  //Initialize the longest subsequence length
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (binaryVector.charAt(i) == '1') {
                longSubSeq[i] = 1;  // Initialize to 1 for the current '1' in the sequence
                if (i > 0 && binaryVector.charAt(i - 1) == '1') {
                    longSubSeq[i] += longSubSeq[i - 1];  // Extend the subsequence from the previous '1'
                }
                maxLength = Math.max(maxLength, longSubSeq[i]);
            }
        }

        return maxLength;
    }

    public String generateBinaryVector(int length) {
        StringBuilder binaryVector = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomDigit = random.nextInt(2);
            binaryVector.append(randomDigit);
        }

        return binaryVector.toString();
    }

    public List<Integer> getLongestPrefix(String[] args) {
        //String inputString = "AAGGCCTTAGCTAGCTTTTAAAGGG";
        int sequenceLength = 8000;
        int numSequences = 1000;
        List<Integer> topSolutions = new ArrayList<>();

        for (int i = 0; i < numSequences; i++) {
            // Generate random sequence of length sequenceLength
            StringBuilder randomSeq = new StringBuilder();
            for (int j = 0; j < sequenceLength; j++) {
                int randomIndex = (int) (Math.random() * 4);
                char randomChar = "AGCT".charAt(randomIndex);
                randomSeq.append(randomChar);
            }
            int longestPrefixLength = findLongestMatchingPrefix(randomSeq.toString(), args[4]);
            topSolutions.add(longestPrefixLength);
        }
        topSolutions.sort(Comparator.reverseOrder());
        List<Integer> topList = topSolutions.subList(0, Math.min(50, topSolutions.size()));

        return topList;
    }

    public int findLongestMatchingPrefix(String randomSeq, String inputString) {
        int currentLength = 0;

        for (int i = 0; i < randomSeq.length(); i++) {
            if (i >= inputString.length() || randomSeq.charAt(i) != inputString.charAt(i)) {
                break;
            }
            currentLength++;
        }
        return currentLength;
    }
}
