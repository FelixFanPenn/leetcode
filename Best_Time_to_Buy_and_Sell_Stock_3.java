/*
public class Solution {
    public int maxProfit(int[] prices) {   // not DP
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
        
        for (int i = 0; i < prices.length; i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;
    }
}
*/
public class Solution {
    public int maxProfit(int[] prices) {     ///using DP
        if(prices.length == 0) return 0;
        int trans = 2;
		int[][] dp = new int[trans+1][prices.length];
		
		for (int i = 1; i <= trans; i++){
		    int min = Integer.MAX_VALUE;
		    for (int j = 1; j < prices.length; j++){
		        min = Math.min(min, prices[j-1] - dp[i-1][j-1]);
		        dp[i][j] = Math.max(dp[i][j-1], prices[j]-min);
		    }
		}
		return dp[trans][prices.length-1];
    }
}
