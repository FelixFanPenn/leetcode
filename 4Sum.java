public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        int len = nums.length;
        
        for (int i = 0; i < len - 3; i++){
            if (i != 0 && nums[i] == nums[i-1]) continue;
            
            for (int j = i+1; j < len-2; j++){
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                
                int k = j+1, l = len-1;
                while(k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k < len-1 && nums[k] == nums[k+1]) k++;
                        while(l > 0 && nums[l] == nums[l-1]) l--;
                        l--;
                    } else if (sum > target){
                        l--;
                    } else {
                        k++;
                    }
                } // end while
            } // end for 
        } // end for
        return res;
    }
}
