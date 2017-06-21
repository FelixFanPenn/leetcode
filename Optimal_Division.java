public class Solution {
    public String optimalDivision(int[] nums) {
        int len = nums.length;
        if (len == 1) return "" + nums[0];
        if (len == 2) return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                sb.append("" + nums[i] + "/(");
            } else if (i == len-1) {
                sb.append(nums[i] + ")");
            } else {
                sb.append(nums[i] + "/");
            }
        }
        return sb.toString();
    }
}