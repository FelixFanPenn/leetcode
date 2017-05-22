public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, 2);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> list, int n, int f){
        
        if (n <= 1){
            if (list.size() > 1){
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);
                res.add(tmp);
            }
            return;
        }
        
        for (int i = f; i <= n; i++){
            if (n % i == 0){
                list.add(i);
                backtrack(res, list, n/i, i);
                list.remove(list.size()-1);
            }
        }
        
        
    }
}