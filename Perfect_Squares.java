public class Solution {
    public int numSquares(int n) {
        if (n <= 1) return n;
        ArrayList<Integer> square = new ArrayList<Integer>();
        
        int i = 1;
        while(i * i <= n){
            square.add(i);
            i++;
        }
        
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int j = 1; j <= n; j++){
            for (int k = square.size()-1; k >= 0; k--){
                if (square.get(k) * square.get(k) <= j){
                    res[j] = Math.min(res[j], 1 + res[j-square.get(k) * square.get(k)]);
                }
            }
        }
        return res[n];
    }
}
