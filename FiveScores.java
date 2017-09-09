import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}

public class FiveScore {
    public static Map<Integer, Double> getHighFive(Result[] results) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (Result res : results) {
            if (!map.containsKey(res.id)) {
                map.put(res.id, new PriorityQueue<>());
            }
            map.get(res.id).offer(res.value);
        }
        
        Map<Integer, Double> retMap = new HashMap<>();
        for (int i : map.keySet()) {
            PriorityQueue<Integer> queue = map.get(i);
            while (queue.size() > 5) queue.poll();
            
            int sum = 0;
            while (queue.size() > 0) sum += queue.poll();
            retMap.put(i, sum * 1.0 / 5.0);
        }
        
        return retMap;
    }
}
