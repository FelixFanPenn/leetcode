public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            int key = 0;
            for (char c : words[i].toCharArray()) {
                key |= 1 << (c - 'a');
            }
            
            for (Integer j : map.keySet()) {
                if ((key & j) == 0) {
                    max = Math.max(map.get(j) * words[i].length(), max);
                }
            }
            int tmp = map.containsKey(key) ? map.get(key) : 0;
            map.put(key, Math.max(words[i].length(), tmp));
        }
        return max;
    }
}