class Solution {
    public String alienOrder(String[] words) {
        Set<char[]> rel = getRel(words);
        Set<Character> allchars = getChar(words);
        StringBuilder sb = new StringBuilder();
        int[] indegree = topo(rel);
        
        Queue<Character> q = new LinkedList<>();
        for (char c : allchars) {
            if (indegree[c] == 0) {
                q.offer(c);
            }
        }
        
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char[] cs : rel) {
                if (cs[0] == c) {
                    indegree[cs[1]]--;
                    if (indegree[cs[1]] == 0) {
                        q.offer(cs[1]);
                    }
                }
            }
        }        
        return sb.length() == allchars.size() ? sb.toString() : "";
    }
    
    private int[] topo(Set<char[]> rel) {
        int[] indegree = new int[256];
        for (char[] cs : rel) {
            indegree[cs[1]]++;
        }
        return indegree;
    }
    
    private Set<char[]> getRel(String[] words) {
        Set<char[]> rel = new HashSet<>();
        for (int i = 1; i < words.length; i++) {
            String s1 = words[i-1], s2 = words[i];
            int idx = 0;
            while (idx < s1.length() && idx < s2.length()) {
                if (s1.charAt(idx) != s2.charAt(idx)) {
                    char[] cs = new char[]{ s1.charAt(idx), s2.charAt(idx)};
                    rel.add(cs);
                    break;
                }
                idx++;
            }
        }
        return rel;
    }
    
    private Set<Character> getChar(String[] words) {
        Set<Character> set = new HashSet<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                set.add(c);
            }
        }
        return set;
    }
}