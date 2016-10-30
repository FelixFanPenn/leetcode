public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int k, int n, int start){
        if (n == 0 && k == tmp.size()){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        if (n < 0) return;
        
        for (int i = start; i <= 9; i++){
            tmp.add(i);
            backtrack(res, tmp, k, n - i, i + 1);
            tmp.remove(tmp.size()-1);
        }
    }
}
