
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length/2) return helper(prices);

        int[] global = new int[k+1];
        int[] local = new int[k+1];
        
        Arrays.fill(local, Integer.MIN_VALUE);
        
        for (int i = 0; i < prices.length; i++) {
            /*
            int diff = prices[i+1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
            */
            
            for (int j = 1; j <= k; j++) {
                local[j] = Math.max(local[j], global[j-1] - prices[i]);
                global[j] = Math.max(global[j], local[j] + prices[i]);
            }
        }
        return global[k];
    }
    
    public int helper(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0, cur = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            max += Math.max(prices[i] - cur, 0);
            cur = prices[i];
        }
        return max;
    }
};

