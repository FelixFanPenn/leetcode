class MagicDictionary {

        Trie trie;
        public MagicDictionary() {
            trie = new Trie(256);
        }

        public void buildDict(String[] dict) {
            Arrays.stream(dict).forEach(s -> trie.insert(s));
        }

        public boolean search(String word) {
            return trie.relaxedSearch(word);
        }

        class Trie {
            private int R;
            private TrieNode root;

            public Trie(int R) {
                this.R = R;
                root = new TrieNode();
            }
            
            public boolean relaxedSearch(String word) {
                return relaxedSearch(root, word, 0);
            }

            private boolean relaxedSearch(TrieNode root, String word, int changedTimes) {
                if (root == null || (!root.isWord && word.isEmpty()) || changedTimes > 1) return false;
                if (root.isWord && word.isEmpty()) return changedTimes == 1;
                return Arrays.stream(root.next).anyMatch(nextNode -> relaxedSearch(nextNode, word.substring(1),
                        root.next[word.charAt(0)] == nextNode ? changedTimes : changedTimes+1));
            }

            // Inserts a word into the trie.
            public void insert(String word) {
                insert(root, word);
            }

            private void insert(TrieNode root, String word) {
                if (word.isEmpty()) { root.isWord = true; return; }
                if (root.next[word.charAt(0)] == null) root.next[word.charAt(0)] = new TrieNode();
                insert(root.next[word.charAt(0)], word.substring(1));
            }

            private class TrieNode {
                private TrieNode[] next = new TrieNode[R];
                private boolean isWord;
            }

        }
    }
/*
class MagicDictionary {

    Map<String, List<int[]>> map = new HashMap<>();
   
    public MagicDictionary() {
    }
    
    public void buildDict(String[] dict) {
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[] {i, s.charAt(i)};
                
                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);
                
                map.put(key, val);
            }
        }
    }
    
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] pair : map.get(key)) {
                    if (pair[0] == i && pair[1] != word.charAt(i)) return true;
                }
            }
        }
        return false;
    }
}
*/

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */