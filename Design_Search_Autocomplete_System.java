public class AutocompleteSystem {
    
    class Pair {
        String str;
        int time;
        Pair(String s, int t) {
            str = s;
            time = t;
        }
    }
    
    class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        boolean isEnd = false;
    }
    
    TrieNode root;
    String prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    public void add(String word, int time) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new TrieNode());
            }
            cur = cur.map.get(c);
            cur.count.put(word, cur.count.getOrDefault(word, 0) + time);
        }
        cur.isEnd = true;
    }
    
    public List<String> input(char c) {
        if ('#' == c) {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        
        prefix += c;
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (!cur.map.containsKey(ch)) return new ArrayList<>();
            cur = cur.map.get(ch);
        }
        
        PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p2.time != p1.time) return p2.time - p1.time;
                return p1.str.compareTo(p2.str);
            }
        });
        
        for (String s : cur.count.keySet()) {
            p.offer(new Pair(s, cur.count.get(s)));
        }
        
        List<String> res = new ArrayList<>();
        while (res.size() != 3 && !p.isEmpty()) {
            res.add(p.poll().str);
        }
        
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */