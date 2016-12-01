public class Solution {
    public int nthUglyNumber(int n) {
        int cur = 1;
        int first = 1, second = 1, third = 1;
        ArrayList<Integer> ugly = new ArrayList<>();
        ugly.add(0);
        ugly.add(1);
        
        while (n > 1){
            cur = Math.min(Math.min(ugly.get(first)*2, ugly.get(second)*3), ugly.get(third)*5);
            ugly.add(cur);
            
            if (cur == ugly.get(first)*2) first++;
            if (cur == ugly.get(second)*3) second++;
            if (cur == ugly.get(third)*5) third++;
            n--;
        }
        return ugly.get(ugly.size()-1);
    }

    /*   way faster!
	public int nthUglyNumber(int n) {
            int[] dp=new int[n];dp[0]=1;
            return DFS(dp,1,0,0,0,n);
    }

    private int DFS(int[] dp, int i, int p2, int p3, int p5, int n) {
        if (i==n)return dp[n-1];
        dp[i]=Math.min(dp[p2]*2, Math.min(dp[p3]*3,dp[p5]*5));
        if (dp[i]==dp[p2]*2)p2++;
        if(dp[i]==dp[p3]*3)p3++;
        if (dp[i]==dp[p5]*5)p5++;
        return DFS(dp, i+1, p2, p3, p5, n);
    }


    */

}
