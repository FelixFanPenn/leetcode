public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        
        backtrack(s, 0, res, "");
        return res;
    }
    
    private void backtrack(String s, int n, List<String> res, String str){
        if (n == 4) {
            if (s.length() == 0) res.add(str);
            return;
        }
        for (int i = 1; i < 4; i++){
            if (s.length() < i) break;
            String tmp = s.substring(0, i);
            int ip = Integer.parseInt(tmp);
            //if (ip > 255 || String.valueOf(ip).length() != i) continue;
    
            if (ip <= 255 && String.valueOf(ip).length() == i)
                backtrack(s.substring(i), n+1, res, str + tmp + ((n == 3)? "" : "."));
            
        }
    }
}
/*
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int i, j, k, p, len = s.length();
        if (len > 12) return res;
        String first, second, third, fourth;
        for (i = 1; i < 4 && i < len-2; i++){
            for (j = i+1; j < i+4 && j < len-1; j++){
                for (k = j+1; k < j+4 && k < len; k++){
                    first = s.substring(0, i);
                    second = s.substring(i, j);
                    third = s.substring(j, k);
                    fourth = s.substring(k, len);
                    if (isValid(first) && isValid(second) && isValid(third) && isValid(fourth)){
                        String tmp = first + '.' + second + '.' + third + '.' + fourth;
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String str){
        if (str.length() == 0 || str.length() > 3 || Integer.parseInt(str) > 255 || Integer.parseInt(str) < 0 || str.length() > 1 && str.charAt(0) == '0') return false;
        return true;
    }
}
*/
