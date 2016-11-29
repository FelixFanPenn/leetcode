public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer first, Integer second){
                return second.intValue() - first.intValue();
            }
        });
        
        for (int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
        }
        
        for (int i = 0; i < k-1; i++){
            queue.poll();
        }
        return queue.poll();
    }
}
