public class Solution {
    public int maxProfit(int[] prices) {
        // check this out:
        // http://www.cnblogs.com/grandyang/p/4997417.html
        
        /*
        int len = prices.length;
        if (len < 2) return 0;
        int[] local = new int[len];
        int[] global = new int[len];
        
        for (int i = 1; i < len; i++) {
            int dif = prices[i] - prices[i-1];
            
            local[i] = Math.max(local[i-1]+dif, dif);
            if (i > 3) {
                local[i] = Math.max(global[i-3]+dif, local[i]);
            }
            global[i] = Math.max(global[i-1], local[i]);
            
        }
        
        return global[len-1];
        */

        int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}