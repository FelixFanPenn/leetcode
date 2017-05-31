public class Solution {
    private Map<Character, Integer> map =
      new HashMap<Character, Integer>() {{
            put('I', 1);  put('V', 5);   put('X', 10);
            put('L', 50); put('C', 100); put('D', 500);
            put('M', 1000);
    }};
    
    public int romanToInt(String s) {
        int sum = 0, pre = 0, cur = 0;
        for (char c : s.toCharArray()){
            cur = map.get(c);
            sum += (cur > pre) ? (cur - 2 * pre) : cur;
            pre = cur;
        }
        return sum;
    }
}