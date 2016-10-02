public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        
        res.add(new ArrayList(tmp));
        for (int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
