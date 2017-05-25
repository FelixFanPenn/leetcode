public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++){
            for (int j = 0; j < points.length; j++){
                if (i == j) continue;
                int dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0)+1);
            }
            
            for (int val : map.values()){
                sum += val * (val-1);
            }
            
            map.clear();
        }
        return sum;
    }
    
    public int getDist(int[] pt1, int[] pt2){
        int a = pt1[0] - pt2[0];
        int b = pt1[1] - pt2[1];
        return a * a + b * b;
    }
}