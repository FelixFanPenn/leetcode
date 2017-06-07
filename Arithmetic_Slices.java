public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length, cur = 0, sum = 0;
        for (int i = 2; i < len; i++){
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                cur++;
                sum += cur;
            }
            else {
                cur = 0;
            }
        }
        return sum;
    }
}