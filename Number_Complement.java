public class Solution {
    public int findComplement(int num) {
        int t = 2;
        while ((t-1) < num){
            t *= 2;
        }
        
        return t - 1 - num;
    }
}