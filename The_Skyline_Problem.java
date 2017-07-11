
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        class Point implements Comparable<Point> {
            int x;
            int height;
            boolean isStart;
            
            Point(int x, int h, boolean start) {
                this.x = x;
                this.height = h;
                this.isStart = start;
            }
            
            @Override
            public int compareTo(Point p) {
                if (this.x != p.x) return this.x - p.x;
                else {
                    if (this.isStart && p.isStart) {                // both are start, put the higher one first
                        return p.height - this.height;
                    } else if (!this.isStart && !p.isStart) {       // both are end, put the lower one first
                        return this.height - p.height;
                    } else {                                        // one start one end, put the start first
                        if (this.isStart) return -1;
                        else return 1;
                    }
                }
            }
        }
        
        Point[] points = new Point[buildings.length * 2];
        int index = 0;
        for (int[] b : buildings) {
            points[index++] = new Point(b[0], b[2], true);
            points[index++] = new Point(b[1], b[2], false);
        }
        Arrays.sort(points);
        
        int max = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 1);
        List<int[]> res = new ArrayList<>();
        for (Point point : points) {
            if (point.isStart) {
                tm.compute(point.height, (k, v) -> {        // get the value of key(point.height), 
                    if (v != null) return v+1;
                    return 1;
                });
            } else {
                tm.compute(point.height, (k, v) -> {
                    if (v == 1) return null;
                    return v-1;
                });
            }
            
            int cur = tm.lastKey();             // get the max key in the tree map
            if (cur != max) {
                res.add(new int[]{point.x, cur});
                max = cur;
            }
        }
        
        return res;
    }
}