public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = mapping(nums);
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){ 
            @Override
            public int compare(int[] q1, int[] q2){
                return q2[1] - q1[1];  /// priority queue is in ascending order
            }  // this override makes the queue in a descending order
        }); /// priorityqueue!!!!
        
        for (int i: map.keySet()){
            queue.offer(new int[]{i, map.get(i)});
        }
        
        for (int i = 0; i < k; i++){
            res.add(queue.poll()[0]);
        }
        return res;
    }
    
    private HashMap<Integer, Integer> mapping(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map;
    }
}
