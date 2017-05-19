public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res;
        
        int pre = 0;
        String tmp = "" + nums[0];

        for (int i = 1; i < len; i++){
            
            if (nums[i] != nums[i-1] + 1) {
                if (pre + 1 < i) {
                    tmp = tmp + "->" + nums[i-1];
                }
                res.add(tmp);
                pre = i;
                tmp = "" + nums[i];
            }
        }
        
        if (pre < len-1){
            tmp = tmp + "->" + nums[len-1];
        }
        res.add(tmp);

        return res;
    }
}

/*
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
*/
