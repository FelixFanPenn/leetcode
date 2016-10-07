class TrieNode {
    // Initialize your data structure here.
    private TrieNode[] links;
    private boolean isEnd;
    private final int R = 26;
    
    public TrieNode() {
        links = new TrieNode[26];
    }
    
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch - 'a'];    
    }
    
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            if (!tmp.containsKey(cur)){
                tmp.put(cur, new TrieNode());
            }
            tmp = tmp.get(cur);
        }
        tmp.setEnd();
    }
    
    private TrieNode searchPrefix(String word){
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            if (!tmp.containsKey(cur)){
                return null;
            } else {
                tmp = tmp.get(cur);
            }
        }
        return tmp;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = searchPrefix(word);
        return tmp != null && tmp.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
