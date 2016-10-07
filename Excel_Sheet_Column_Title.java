public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        while(n != 0){
            int num = (n-1) % 26;
            res = str.charAt(num) + res;
            n = (n-1) / 26;
        }
        return res;
    }
}
