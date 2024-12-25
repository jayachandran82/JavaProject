package interview;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This program generates a random collection of tasks,finds the solution for each task,
 * ranks the solutions and prints the top 50 solutions.
 * 1). LongestOnes
 */
public class LongestOnes {
    public static void main(String[] args) {
        int randomGeneratedSeeds = 0;//8000
        int nooOfTaskGenerator = 0; //1234

        try {
            if (args.length == 1) {
                randomGeneratedSeeds = Integer.parseInt(args[0]);
            } else if (args.length > 1 && args.length <= 2) {
                randomGeneratedSeeds = Integer.parseInt(args[0]);
                nooOfTaskGenerator = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("The input entered is invalid. Please enter integer number.");
        }


        List<Integer> topSolutions = new ArrayList<>();
        for (int i = 0; i < nooOfTaskGenerator; i++) {
            String binaryVector = generateBinaryVector(randomGeneratedSeeds);
            int longestOnesLength = findLongestOnesSequence(binaryVector);
            topSolutions.add(longestOnesLength);
        }
        topSolutions.sort((a, b) -> b - a);

        List<Integer> topList = topSolutions.subList(0, Math.min(50, topSolutions.size()));

        System.out.println("Display top 50 solutions, Ranked by descending solution length:");
        for (int i = 0; i < topList.size(); i++) {
            System.out.println(" Top " + (i + 1) + " rank value : " + topList.get(i));
        }
    }

    public static int findLongestOnesSequence(String binaryVector) {
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

    public static String generateBinaryVector(int length) {
        StringBuilder binaryVector = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomDigit = random.nextInt(2);
            binaryVector.append(randomDigit);
        }

        return binaryVector.toString();
    }

}
