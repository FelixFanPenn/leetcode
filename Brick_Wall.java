public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> list = wall.get(i);
            int sum = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                sum += list.get(j);
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
                if (max < map.get(sum)) max = map.get(sum);
            }
        }
        
        return wall.size() - max;
    }
}