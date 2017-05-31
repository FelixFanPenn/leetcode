public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        backtrack(list, "", digits, 0, strs);
        
        return list;
    }
    
    public void backtrack(List<String> list, String res, String digits, int index, String[] strs){
        if (index == digits.length()) {
            list.add(res);
            return;
        }
        
        int cur = digits.charAt(index) - '0';
        String curs = strs[cur];
        for (int i = 0; i < curs.length(); i++){
            res += curs.charAt(i);
            backtrack(list, res, digits, index+1, strs);
            res = res.substring(0, res.length()-1);
        }
    }
}