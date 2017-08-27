class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int idx = 0, start = 0;
        for (int i = 1, j = n; i <= j; ) {
            if (idx < n - k - 1) {
                res[idx++] = i++;
            } else {
                res[idx++] = start++ % 2 == 0 ? i++ : j--;
            }
        }
        return res;
    }
}