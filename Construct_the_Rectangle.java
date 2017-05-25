public class Solution {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int w, l;
        int sq = (int)Math.sqrt(area);
        for (int i = sq; i >= 1; i--){
            if (area % i == 0) {
                res[0] = area / i;
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}