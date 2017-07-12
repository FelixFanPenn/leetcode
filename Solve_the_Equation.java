public class Solution {
    public String solveEquation(String equation) {
        int[] res1 = process(equation.split("=")[0]);
        int[] res2 = process(equation.split("=")[1]);
        int[] res = new int[2];
        res[0] = res1[0] - res2[0];
        res[1] = res2[1] - res1[1];
        
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        if (res[0] == 0) return "No solution";
        
        return "x=" + res[1] / res[0];
    }
    
    public int[] process(String str) {
        String[] tokens = str.split("(?=[-+])");
        
        /*
        (?=regex_here) is a positive lookahead. 
        It is a zero-width assertion, meaning that it matches a location 
        that is followed by the regex contained within (?= and ).
        */
        
        int[] res = new int[2];
        
        for (String s : tokens) {
            if (s.equals("+x") || s.equals("x")) {
                res[0]++;
            } else if (s.equals("-x")) {
                res[0]--;
            } else if (s.indexOf("x") != -1) {
                res[0] += Integer.parseInt(s.substring(0, s.indexOf("x")));
            } else {
                res[1] += Integer.parseInt(s);
            }
        }
        return res;
    }
}