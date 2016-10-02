public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, int target, int start){
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        } else if (target < 0){
            return;
        } else {
            for (int i = start; i < nums.length && nums[i] <= target; i++){
                if (i > start && nums[i] == nums[i-1]) continue;  // avoid dups!!!
                tmp.add(nums[i]);
                backtrack(res, tmp, nums, target-nums[i], i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
