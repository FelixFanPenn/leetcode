public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        
        String mid = "", front = "";
        for (Character c : map.keySet()) {
            int r = map.get(c) % 2;
            
            if (r == 0) {
                int i = 0;
                while (i < map.get(c) / 2) {
                    front += c; i++;
                }
            } else {
                int i = 0;
                mid += c;
                while (i < map.get(c) / 2) {
                    front += c; i++;
                }
            }
            if (mid.length() > 1) return res;
        }
        
        char[] elements = front.toCharArray();
        Arrays.sort(elements);
        generatePermute(elements, new ArrayList<Character>(), res, mid, new boolean[front.length()]);
        return res;
    }
    
    public void generatePermute(char[] chars, List<Character> permutation, List<String> list, String mid, boolean[] used) {
        if (permutation.size() == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (char c : permutation) {
                sb.append(c);
            }
            list.add(sb.toString() + mid + sb.reverse().toString());
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i-1] && !used[i-1])) continue;
            permutation.add(chars[i]);
            used[i] = true;
            generatePermute(chars, permutation, list, mid, used);
            used[i] = false;
            permutation.remove(permutation.size()-1);
        }
        
    }
}