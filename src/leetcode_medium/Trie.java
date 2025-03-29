package leetcode_medium;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * <p>
 * Example 1:
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * <p>
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * <p>
 * https://www.youtube.com/watch?v=giiaIofn31A&ab_channel=AlgosWithMichael
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Trie {
    TrieNode root;

    Trie() {
        //Store Empty Node
        root = new TrieNode('\0');
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode(c);
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }


    private boolean search(String word) {
        TrieNode node = getSearch(word);
        return node != null && node.isEnd;
    }

    boolean startsWith(String prefix) {
        return getSearch(prefix) != null;
    }

    private TrieNode getSearch(String words) {
        TrieNode curr = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }


    private class TrieNode {
        char c;
        TrieNode[] children;
        boolean isEnd;

        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search : " + trie.search("apple"));   // Output: true
        System.out.println("Search : " + trie.search("app"));     // Output: false
        System.out.println("startsWith : " + trie.startsWith("app")); // Output: true
        trie.insert("app");
        System.out.println("Search : " + trie.search("app"));     // Output: true
    }
}
