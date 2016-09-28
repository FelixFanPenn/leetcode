/*
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        int n = prices.length;
        if (k > n/2) {
            int res = 0;
            for (int i = 1; i < n; i++){
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);             // initialize values for arrays
        
        for (int i = 0; i < n; i++){
            int tmp = 0;
            for (int j = 0; j < k; j++) {
                int buffer = 0;                          // used to avoid duplicate calculation
                buffer = tmp - prices[i];
                if (buy[j] < buffer) buy[j] = buffer;
                
                buffer = buy[j] + prices[i];
                if (sell[j] < buffer) sell[j] = buffer;
                tmp = sell[j];
            }
        }
        return sell[k-1];
    }
}
*/

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n/2) {
            int res = 0;
            for (int i = 1; i < n; i++){
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        int[] buy = new int[k+1];
        int[] sale = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= k; j++){
                buy[j] = Math.max(buy[j], sale[j - 1] - prices[i]);
                sale[j] = Math.max(sale[j], buy[j] + prices[i]);
            }
        }
        return sale[k];
    }
};

