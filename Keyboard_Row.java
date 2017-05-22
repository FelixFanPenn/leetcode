public class Solution {
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        
        List<String> list = new ArrayList<>();
        
        for (String str : words){
            char[] chars = str.toLowerCase().toCharArray();
            boolean b1 = true, b2 = true, b3 = true;
            for (char c : chars){
                if (b1) {
                    if (!set1.contains(c)) b1 = false;
                }
                
                if (b2) {
                    if (!set2.contains(c)) b2 = false;
                }
                
                if (b3) {
                    if (!set3.contains(c)) b3 = false;
                }
            }
            if (b1 || b2 || b3) list.add(str); 
        }
        
        String[] strs = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            strs[i] = list.get(i);
        }
        return strs;
    }
}