public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int row = picture.length;
        if (row == 0) return 0;
        int col = picture[0].length;
        
        int[] r = new int[row];
        int[] c = new int[col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (picture[i][j] == 'B') {
                    r[i]++; c[j]++;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (picture[i][j] == 'B' && r[i] == 1 && c[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}