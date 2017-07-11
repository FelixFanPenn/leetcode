public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num.length() == 0) return list;
        char[] digits = num.toCharArray();
        char[] paths = new char[digits.length * 2 - 1];
        long n = 0;
        
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            paths[i] = digits[i];
            dfs(list, paths, i+1, 0, n, digits, i+1, target);
            if (n == 0) break;
        }
        return list;
        
    }
    
    void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
        if (pos == digits.length) {
            if (left + cur == target) {
                String str = new String(path, 0, len);
                ret.add(str);
            }
            return;
        }
        
        long n = 0; int j = len+1;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[len] = '+';
            dfs(ret, path, j, left+cur, n, digits, i+1, target);
            path[len] = '-';
            dfs(ret, path, j, left+cur, -n, digits, i+1, target);
            path[len] = '*';
            dfs(ret, path, j, left, cur * n, digits, i+1, target);
            if (digits[pos] == '0') break;
        }
        
    }
}