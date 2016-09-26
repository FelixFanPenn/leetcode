class Solution {
    public int numTrees(int n) {
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        if (n < 2) return array[n];
        
        for (int i = 2; i <= n; i++){
            int res = 0;
            for (int j = 0; j < i; j++){
                res += array[j] * array[i-j-1];
            }
            array[i] = res;
        }
        return array[n];
    }
}
