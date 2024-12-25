package leetcode_easy;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "mapsadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Time Complexity: O(n+m)   => O(m), where 𝑚 is the length of the pattern. O(n), where 𝑛 is the length of the text.
 * Space Complexity: O(m)
 */
public class Find_Index_First_Occurrence_String {
    //Find the Index of the First Occurrence in a String

    private static int findFirstOccurrence(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return 0;
        int i = 0, j = 0;
        int[] lps = computeLPSArray(pattern);
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return i - j; // Match found and return the stating index.
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }

        }
        return -1; // No Match found
    }

    private static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int length = 0, i = 1;
        lps[0] = 0;
        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "mapsadbutsad";
        String pattern = "sad";

        int indexValue = findFirstOccurrence(text, pattern);
        System.out.println("Index Value : " + indexValue);
        //Option -1
        //System.out.println(" Option-2 " + strStr(text, pattern));
    }


    //Two steps: 1). Check the first character 2). Check the SubString
    // Note: If we use string, and it occupies more memory space.
    static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;

    }
}
