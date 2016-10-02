public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] candidates, int target, int start){
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(tmp));   /// very important!!!
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++){
            tmp.add(candidates[i]);
            backtrack(res, tmp, candidates, target-candidates[i], i);
            tmp.remove(tmp.size()-1);
        }
    }
}
