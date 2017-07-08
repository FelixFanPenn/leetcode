public class Solution {
    
    class TrieNode {
        public TrieNode[] links = new TrieNode[26];
        public String word = "";
        
        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }
        
        public TrieNode get(char c) {
            return links[c - 'a'];
        }
        
        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }
        
        public void setWord(String string) {
            word = string;
        }
    }
    
    class Trie {
        TrieNode node = new TrieNode();
        public void addWord(String word) {
            TrieNode tmp = node;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!tmp.containsKey(c)) {
                    tmp.put(c, new TrieNode());
                }
                tmp = tmp.get(c);
            }
            tmp.setWord(word);
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) return res;
        
        Trie root = new Trie();
        for (String str : words) {
            root.addWord(str);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(root.node, board, res, i, j);
            }
        }
        return res;
        
    }
    
    public void backtrack(TrieNode root, char[][] board, List<String> res, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (c == ' ' || !root.containsKey(c)) return;
        root = root.get(c);
        
        if (!root.word.equals("")) {
            res.add(root.word);
            root.word = "";
        }
        
        board[i][j] = ' ';

        backtrack(root, board, res, i+1, j);
        backtrack(root, board, res, i-1, j);
        backtrack(root, board, res, i, j+1);
        backtrack(root, board, res, i, j-1);
        
        board[i][j] = c;
        return;
        
    }
}