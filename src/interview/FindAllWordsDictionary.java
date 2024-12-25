package interview;

import java.util.HashMap;
import java.util.Map;
	
public class FindAllWordsDictionary {
    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode() {}

        public TrieNode(char c){
            this.c = c;
        }
    }
    private TrieNode root;
 
    public FindAllWordsDictionary() {
        root = new TrieNode();
    }
 
    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
 
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
 
            TrieNode t;
            if(children.containsKey(c)){
                  t   = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
 
            children = t.children;
 
            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;    
        }
    }
 
    // Returns if the word is in the trie.
    /*  public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isLeaf) 
            return true;
        else
            return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
 
    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
 
        return t;
    }*/
    
 // The main method that finds out the longest string 'input' 
    public String getMatchingPrefix(String input)  { 
        String result = ""; // Initialize resultant string 
        int length = input.length();  // Find length of the input string        
  
        // Initialize reference to traverse through Trie 
        TrieNode crawl = root;    
  
        // Iterate through all characters of input string 'str' and traverse 
        // down the Trie 
        int level, prevMatch = 0; 
        for( level = 0 ; level < length; level++ ) 
        { 
            // Find current character of str 
            char ch = input.charAt(level);     
  
            // HashMap of current Trie node to traverse down 
            HashMap<Character,TrieNode> child = root.children;                         
  
            // See if there is a Trie edge for the current character 
            if( child.containsKey(ch) ) 
            { 
               result += ch;          //Update result 
               crawl = child.get(ch); //Update crawl to move down in Trie 
  
               // If this is end of a word, then update prevMatch 
               if( root.isLeaf ) 
                    prevMatch = level + 1; 
            } 
            else  break; 
        } 
  
        // If the last processed character did not match end of a word, 
        // return the previously matching prefix 
        if( !root.isLeaf ) 
                return result.substring(0, prevMatch);         
  
        else return result; 
    } 
    
    public static void main(String[] args) {
    	FindAllWordsDictionary dict = new FindAllWordsDictionary();
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
        dict.insert("basement");
        
        String input = "cat";
        System.out.print(input + ":   ");
        //System.out.println(dict.search(input));
        System.out.println(dict.getMatchingPrefix(input));
    }
}