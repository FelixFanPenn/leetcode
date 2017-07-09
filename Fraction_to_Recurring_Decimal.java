public class Solution {
    public String fractionToDecimal(int n, int d) {
        if (n == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        
        res.append(((n > 0) ^ (d > 0)) ? "-" : "");
        
        long num = Math.abs((long)n);
        long den = Math.abs((long)d);
        
        res.append(num / den);
        long r = num % den;
        
        if (r == 0) return res.toString();
        
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(r, res.length());
        while (r != 0) {
            r *= 10;
            res.append(r / den);
            r %= den;
            if (map.containsKey(r)) {
                int index = map.get(r);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(r, res.length());
            }
        }
        
        return res.toString();
    }
}