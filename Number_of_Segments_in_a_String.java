public class Solution {
    public int countSegments(String s) {
        int count = 0;
        for (String str : s.split(" ")){
            if (!str.equals("")) count++;
        }
        return count;
    }
}