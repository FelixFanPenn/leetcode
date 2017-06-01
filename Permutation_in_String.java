public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] chars = new int[26];
        
        for (int i = 0; i < len1; i++){
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        if (isArrayAllZero(chars)) return true;
        int left = 0;
        for (int i = len1; i < len2; i++){
            chars[s2.charAt(left++) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
            if (isArrayAllZero(chars)) return true;
        }
        return false;
    }
    
    public boolean isArrayAllZero(int[] chars){
        for (int i : chars){
            if (i != 0) return false;
        }
        return true;
    }
}