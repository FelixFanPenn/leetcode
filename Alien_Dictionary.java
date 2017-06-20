public class Solution {
    public String alienOrder(String[] words) {
        HashSet<char[]> set = new HashSet<>();
        HashSet<Character> all = new HashSet<>();
        
        addAllChars(all, words);
        
        getRelations(set, words);
        
        String res = "";
        
        int[] chars = new int[256];
        topoPrep(chars, set);
        
        Queue<Character> q = new LinkedList<>();
        for (char c : all) {
            if (chars[c] == 0) {
                q.offer(c);
                res += c;
            }
        }
        
        while (!q.isEmpty()) {
            char c = q.poll();
            for (char[] temp : set) {
                if (c == temp[0]) {
                    chars[temp[1]]--;
                    if (chars[temp[1]] == 0) {
                        q.offer(temp[1]);
                        res += temp[1];
                    }
                }
            }
        }
        return res.length() == all.size()? res : "";
    }
    
    public void addAllChars(HashSet<Character> all, String[] words) {
        for (String str : words) {
            for (char c : str.toCharArray())
                all.add(c);
        }
    }
    
    public void getRelations(HashSet<char[]> set, String[] words) {
        for (int i = 0; i < words.length-1; i++) {
            String s1 = words[i], s2 = words[i+1];
            int l1 = s1.length(), l2 = s2.length(), l = 0;
            while (l < l1 && l < l2) {
                if (s1.charAt(l) != s2.charAt(l)) {
                    char[] tmp = new char[2];
                    tmp[0] = s1.charAt(l);
                    tmp[1] = s2.charAt(l);
                    set.add(tmp);
                    break;
                }
                l++;
            }
        }
    }
    
    public void topoPrep(int[] chars, HashSet<char[]> set) {
        Arrays.fill(chars, 0);
        for (char[] temp : set) {
            chars[temp[1]]++;
        }
    }
}