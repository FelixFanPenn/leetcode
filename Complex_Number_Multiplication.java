public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+"), bs = b.split("\\+");  // + is a special character so have to use \\+
        int ar = Integer.parseInt(as[0]);
        int br = Integer.parseInt(bs[0]);
        int ac = Integer.parseInt(as[1].substring(0, as[1].length()-1));
        int bc = Integer.parseInt(bs[1].substring(0, bs[1].length()-1));
        
        int real = ar * br - ac * bc;
        int comp = ar * bc + br * ac;
        String res = "";
        res += real + "+" + comp + "i";
        return res;
    }
}