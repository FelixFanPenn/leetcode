public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++){
                if (tmp.contains(nums[i])) continue;
                tmp.add(nums[i]);
                backtrack(res, tmp, nums);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
