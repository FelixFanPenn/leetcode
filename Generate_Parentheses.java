public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        help("", n, n, res);
        return res;
    }
    
    public void help(String tmp, int m, int n, List<String> res){
        if (m == 0 && n == 0){
            res.add(tmp);
            return;
        }
        
        if (m > 0){
            help(tmp + '(', m-1, n, res);
        }
        if (m < n){
            help(tmp + ')', m, n-1, res);
        }
    }
}
