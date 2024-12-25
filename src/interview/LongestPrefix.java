package interview;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestPrefix {


    public static void main(String[] args) {
        String inputString = "AAGGCCTTAGCTAGCTTTTAAAGGG";
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

            int longestPrefixLength = findLongestMatchingPrefix(randomSeq.toString(), inputString);
            topSolutions.add(longestPrefixLength);
        }

        topSolutions.sort(Comparator.reverseOrder());

        // Get the top 50 solutions
        List<Integer> topList = topSolutions.subList(0, Math.min(50, topSolutions.size()));

        System.out.println("Display Longest Prefix top 50 solutions, Ranked by descending solution length:");
        for (int i = 0; i < topList.size(); i++) {
            System.out.println(" Top " + (i + 1) + " rank value : " + topList.get(i));
        }
    }

    public static int findLongestMatchingPrefix(String randomSeq, String inputString) {
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
