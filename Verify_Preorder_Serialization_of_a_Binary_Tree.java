public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int count = 0;
        for (int i = 0; i < strs.length-1; i++) {
            if (strs[i].equals("#")) {
                count--;
                if (count < 0) return false;
            } else {
                count++;
            }
        }
        if (count == 0) return strs[strs.length-1].equals("#");
        return false;
        
    }
}