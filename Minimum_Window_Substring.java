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
/*
public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (t.length() == 0 || s.length() == 0) return res;
    
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            if (tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }
        
        int left = 0, minLen = s.length()+1, minLeft = 0, count = 0;
        for (int right = 0; right < s.length(); right++){
            if (tMap.containsKey(s.charAt(right))){
                
                tMap.put(s.charAt(right), tMap.get(s.charAt(right))-1);
                
                if (tMap.get(s.charAt(right)) >= 0){
                    count++;
                }
                
                while(count == t.length()){
                    if (right - left + 1 < minLen){
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    
                    if (tMap.containsKey(s.charAt(left))){
                        tMap.put(s.charAt(left), tMap.get(s.charAt(left))+1);
                        
                        if (tMap.get(s.charAt(left)) > 0){
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen == s.length()+1) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}

*/