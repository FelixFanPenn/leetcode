class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        
        int cnt = 0, left = 0, right = 0, len = Integer.MAX_VALUE;
        int l = 0, r = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c) >= 0) cnt++;
                
                while (cnt == t.length()) {
                    if (len > right - left) {
                        l = left;
                        r = right;
                        len = right - left;
                    }
                    char ch = s.charAt(left++);
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch)+1);
                        if (map.get(ch) > 0) cnt--;
                    }
                }
            }
        }
        return s.substring(l, r);
    }
}

public class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length(), len2 = t.length(), left = 0, right = len2, min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        if (len2 > len1) return "";
        int[] nums = new int[256];
        
        for (int i = 0; i < len2; i++){
            nums[s.charAt(i)]++;
            nums[t.charAt(i)]--;
        }
        if (allPositive(nums)) return s.substring(0, len2);
        
        while (right < len1){
            nums[s.charAt(right++)]++;
            
            while (allPositive(nums)){
                if (min > right - left) {
                    r = right; l = left;
                    min = right - left;
                }
                nums[s.charAt(left++)]--;
            }
        }
        return r == 0? "" : s.substring(l, r);
    }
    
    public boolean allPositive(int[] nums){
        for (int i : nums){
            if (i < 0) return false;
        }
        return true;
    }
}