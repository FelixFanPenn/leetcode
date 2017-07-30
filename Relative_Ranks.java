public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[][] pairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                res[pairs[i][1]] = "Gold Medal";
            } else if (i == 1) {
                res[pairs[i][1]] = "Silver Medal";
            } else if (i == 2) {
                res[pairs[i][1]] = "Bronze Medal";
            } else {
                res[pairs[i][1]] = i + 1 + "";
            }
        }
        return res;
    }
}