public class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        if (n == 0) return true;
        for (int i = 0; i < f.length; i++) {
            if (i == 0) {
                if (f[i] == 0) {
                    if (i+1 == f.length || f[i+1] == 0){
                        n--;
                        f[0] = 1;
                    }
                }
            } else if (i == f.length-1) {
                if (f[i-1] == 0 && f[i] == 0) {
                    n--;
                    f[i] = 1;
                }
            } else {
                if (f[i-1] == 0 && f[i] == 0 && f[i+1] == 0) {
                    n--;
                    f[i] = 1;
                }
            }
            if (n == 0) break;
        }
        return n == 0;
    }
}