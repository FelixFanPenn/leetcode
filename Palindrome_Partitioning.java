public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

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
