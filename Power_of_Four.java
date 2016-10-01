public class Solution {
    public boolean isPowerOfFour(int num) {
        int x = (int)Math.sqrt(num);
        return num > 0 && 1073741824 % num == 0 && x*x == num;
    }
}
