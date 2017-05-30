/*
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, n, n, "");
        return list;
    }
    
    public void backtrack(List<String> list, int n, int m, String str){
        if (m == 0 && n == 0) {
            list.add(str);
            return;
        }
        if (n == m && n > 0) {
            str = str + '(';
            n--;
            backtrack(list, n, m, str);
        } else if (n < m && n >= 0){
            str = str + '(';
            n--;
            backtrack(list, n, m, str);
            n++;
            m--;
            str = str.substring(0, str.length()-1) + ')';
            backtrack(list, n, m, str);
        }
    }
}

*/

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
