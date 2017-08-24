public class Solution {
    public List<String> letterCombinations(String digits) {
        /*
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(digits, 0, strs, res, "");
        return res;
        */
        if (digits.length() == 0) return new ArrayList<String>();
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (ans.peek().length() == i) {
                String s = ans.poll();
                for (char c : mapping[num].toCharArray()) {
                    ans.offer(s + c);
                }
            }
        }
        return ans;
    }
    
    /*
    public void helper(String digits, int index, String[] strs, List<String> res, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        } else {
            int num = digits.charAt(index) - '0';
            String tmp = strs[num];
            for (int i = 0; i < tmp.length(); i++) {
                helper(digits, index+1, strs, res, s + tmp.charAt(i));
            }
        }
    }
    */
}