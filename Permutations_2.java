public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, boolean[] used){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++){
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                tmp.add(nums[i]);
                backtrack(res, tmp, nums, used);
                used[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
