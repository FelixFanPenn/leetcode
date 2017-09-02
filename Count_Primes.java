class Solution {
    public int countPrimes(int n) {
        boolean[] res = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (res[i]) continue;
            count++;
            for (int j = 2 * i; j < n; j += i) {
                res[j] = true;
            }
        }
        
        return count;
    }
}