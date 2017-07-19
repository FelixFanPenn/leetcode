public class Solution {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int pos = findValidPos(count, valid, i);
            if (pos == -1) return "";
            count[pos]--;
            valid[pos] = i + k;
            sb.append((char)('a' + pos));
        }
        
        return sb.toString();
    }
    
    public int findValidPos(int[] count, int[] valid, int index) {
        int max = -1, pos = -1;
        
        for (int i = 0; i < 26; i++) {
            if (max < count[i] && count[i] > 0 && index >= valid[i]) {
                max = count[i];
                pos = i;
            }
        }
        
        return pos;
    }
}