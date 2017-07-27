public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0 || pairs[0].length == 0) return 0;
        int row = pairs.length, max = 0;
        int[] res = new int[row];
        Arrays.fill(res, 1);
        
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    res[i] = Math.max(res[i], 1 + res[j]);
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}