public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int cur = points[0][1];
        int count = 1;
        
        for (int i = 1; i < points.length; i++) {
            if (cur >= points[i][0]) continue;
            cur = points[i][1];
            count++;
        }
        return count;
    }
}