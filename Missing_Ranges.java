public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int next = lower;
        ArrayList<String> res = new ArrayList<>();
        String str = "";
        
        for (int i : nums){
            if (next > i){
                continue;
            }
            if (next == i){
                next++;
                continue;
            }
            str = getRange(next, i-1);
            next = i + 1;
            res.add(str);
            if (i == Integer.MAX_VALUE){
                return res;
            }
        }
        
        if (next <= upper){
            str = getRange(next, upper);
            res.add(str);
        }
        return res;
        
    }


    public String getRange(int n1, int n2){
        return (n1 == n2) ? "" + n1 : n1 + "->" + n2;
    }
}

/*
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> res = new ArrayList<>();
        String str = "";
        int len = nums.length;
        if (len == 0){
            if (lower < upper){
                str = lower + "->" + upper;
            } else {
                str = "" + lower;
            }
            res.add(str);
            return res;
        }
        
        if (lower + 1 < nums[0]){
            res.add(lower + "->" + (nums[0] - 1));
        } else if (lower + 1 == nums[0]){
            res.add("" + lower);
        }
        
        for (int i = 1; i < len; i++){
            if (nums[i] - 1 > nums[i-1] + 1){
                str = (nums[i-1] + 1) + "->" + (nums[i] - 1);
                res.add(str);
            } else if (nums[i] - 1 > nums[i-1]){
                res.add(""+ (nums[i] - 1));
            }
            
        }
        
        if (upper-1 > nums[len-1]){
            res.add((nums[len-1] + 1) + "->" + upper);
        } else if (upper-1 == nums[len-1]){
            res.add("" + upper);
        }
        return res;
    }
}

*/
