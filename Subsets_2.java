public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){

        res.add(new ArrayList(tmp));
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i-1]) continue;  ///avoid dups!!!!
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
