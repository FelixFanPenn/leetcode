public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left = leftMost(image, 0, y, true);
        int right = rightMost(image, y, image[0].length-1, true);
        int top = leftMost(image, 0, x, false);
        int bottom = rightMost(image, x, image.length-1, false);
        return (bottom - top + 1) * (right - left + 1);
    }
    
    public int leftMost(char[][] image, int l, int r, boolean h) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (!hasBlack(image, mid, h)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    
    public int rightMost(char[][] image, int l, int r, boolean h) {
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (!hasBlack(image, mid, h)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
    
    public boolean hasBlack(char[][] image, int mid, boolean h) {
        if (h) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') return true;
            }
            return false;
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[mid][i] == '1') return true;
            }
            return false;
        }
    }
}