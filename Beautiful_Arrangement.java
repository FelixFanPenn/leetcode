public class Solution {
    public int countArrangement(int n) {

        int[] res = new int[1];
        res[0] = 0;
        backtrack(1, n, res, new boolean[n+1]);
        return res[0];
    }
    
    public void backtrack(int index, int n, int[] res, boolean[] bools) {
        if (index > n) {
            res[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (bools[i] == false && (index % i == 0 || i % index == 0)) {
                bools[i] = true;
                backtrack(index+1, n, res, bools);
                bools[i] = false;
            }
        }
    }
}
