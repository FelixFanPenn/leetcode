public class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        String str = "";
        boolean inRange = false;
        for (int i = 0; i < nums.length; i++){
            
            if (i == nums.length-1 || nums[i] + 1 != nums[i+1]){
                if (inRange){
                    str += "->" + nums[i];
                    res.add(str);
                    str = "";
                    inRange = false;
                } else {
                    str += nums[i];
                    res.add(str);
                    str = "";
                    inRange = false;
                }
            } else {
                if (i == 0 || nums[i] - 1 != nums[i-1]){
                    str += nums[i];
                    inRange = true;
                }
            }
        }
        return res;
    }
}
