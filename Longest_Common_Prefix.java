public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int row = strs.length;
        String pre = "";
        for (int j = 0; j < strs[0].length(); j++){
            for (int i = 0; i < row; i++){
                if (j >= strs[i].length()) return pre;
                if (strs[0].charAt(j) != strs[i].charAt(j)) return pre;
            }
            pre += strs[0].charAt(j);
        }
        return strs[0];
    }
}
