public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        backtrack(res, new ArrayList<String>(), s, 0);
        return res;
    }
    
    private void backtrack(List<List<String>> res, ArrayList<String> tmp, String s, int start){
        if (start == s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        } else {
            for (int i = start; i < s.length(); i++){
                if (isPalin(s, start, i)){
                    tmp.add(s.substring(start, i+1));
                    backtrack(res, tmp, s, i+1);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
    
    private boolean isPalin(String str, int low, int high){
        while(low < high && str.charAt(low) == str.charAt(high)){
            low++; high--;
        }
        return low >= high;
    }
}
