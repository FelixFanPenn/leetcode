public class Solution {   // possible priorityqueue
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] array = new int[primes.length];
       // Arrays.fill(array, 1);
        dp[0] = 1;
        
        for (int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++){
                min = Math.min(min, dp[array[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++){
                while (primes[j] * dp[array[j]] <= dp[i]){
                    array[j]++;
                }
            }
        }
        
        return dp[n-1];
    }

}
