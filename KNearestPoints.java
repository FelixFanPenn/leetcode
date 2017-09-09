import java.util.Comparator;
import java.util.PriorityQueue;

class Point {
    int x, y;
    public Point(int a, int b) {
        x = a;
        y = b;
    }
}
public class KClosestPoints {
    Point[] findPoints(Point[] arr, Point origin, int k) {
        if (arr == null || arr.length == 0 || origin == null || k <= 0) return new Point[0];
        
        PriorityQueue<Point> points = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return dist(p1, origin) - dist(p2, origin);
            }
        });
        
        for (Point point : arr) {
            points.offer(point);
        }
        
        int size = points.size();
        Point[] res = new Point[size];
        
        for (int i = 0; i < size; i++) {
            res[i] = points.poll();
        }
        return res;
    }
    
    public int dist(Point p, Point origin) {
        return (p.x - origin.x) * (p.x - origin.x)  + (p.y - origin.y) * (p.y - origin.y);
    }
}
