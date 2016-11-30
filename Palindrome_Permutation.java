public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        
        return set.size() <= 1;
    }
}

/*
public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int val = map.containsKey(c)? map.get(c) : 0;
            map.put(c, val + 1);
        }
        
        boolean hasSingle = false;
        for (Character c : map.keySet()){
            if (map.get(c) % 2 == 1 && !hasSingle){
                hasSingle = true;
            } else if (map.get(c) % 2 == 1 && hasSingle){
                return false;
            }
        }
        return true;
    }
}
*/
