public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null) return -1;

        int[] res = new int[amount+1];
        res[0] = 0;
        for (int i = 1; i <= amount; i++){
            res[i] = Integer.MAX_VALUE-1;
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0){
                    res[i] = Math.min(res[i], res[i-coins[j]] + 1);
                } 
            }
        }
        
        if (res[amount] == Integer.MAX_VALUE-1) return -1;
        return res[amount];
    }
}
