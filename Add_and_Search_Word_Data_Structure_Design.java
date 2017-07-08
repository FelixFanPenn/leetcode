public class WordDictionary {
    
    class TrieNode {
        public TrieNode[] links;
        public boolean isEnd;
        
        TrieNode() {
            links = new TrieNode[26];
        }
        
        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }
        
        public TrieNode get(char c) {
            return links[c - 'a'];
        }
        
        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!tmp.containsKey(c)) {
                tmp.put(c, new TrieNode());
            }
            tmp = tmp.get(c);
        }
        tmp.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        return match(word, 0, root);
        
    }
    
    public boolean match(String word, int k, TrieNode node) {
        if (k == word.length()) return node.isEnd();   
        char c = word.charAt(k);
        if (c != '.') {
            return node.get(c) != null && match(word, k+1, node.get(c));
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null && match(word, k+1, node.links[i])) return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */