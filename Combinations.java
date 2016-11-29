public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, res, new ArrayList<Integer>(), 1);
        return res;
    }
    
    public void backtrack(int n, int k, List<List<Integer>> res, List<Integer> tmp, int min){
        if (tmp.size() == k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = min; i <= n; i++){
            if (!tmp.contains(i)){
                tmp.add(i);
                backtrack(n, k, res, tmp, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
