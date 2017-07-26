public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            for (int j = 0; j <= str.length(); j++) {
                String s1 = str.substring(0, j);
                String s2 = str.substring(j);
                
                if (isPalin(s1)) {
                    String s2Rev = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2Rev) && map.get(s2Rev) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(s2Rev));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (s2.length() > 0 && isPalin(s2)) {
                    String s1Rev = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1Rev) && map.get(s1Rev) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(s1Rev));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isPalin(String str) {
        int l = 0, r = str.length()-1;
        while (l < r && str.charAt(l) == str.charAt(r)) {
            l++; r--;
        }
        return l >= r;
    }
}