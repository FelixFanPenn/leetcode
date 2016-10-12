public class Solution {
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        if (len == 0) return 0;
        int sum = 0, max = 0, itr = 0;
        
        for (int j = 0; j < len; j++){
            sum += A[j];
            itr += (j * A[j]);
        }
        
        max = itr;
        for (int j = 0; j < len-1; j++){
            itr = itr - sum + len * A[j];
            max = Math.max(max, itr);
        }
    
        return max;
    }
}

//https://discuss.leetcode.com/topic/58616/java-solution-o-n-with-non-mathametical-explaination
