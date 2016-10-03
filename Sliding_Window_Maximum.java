/*
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int len = nums.length, index = 0;
        int[] res = new int[len-k+1];
        Deque<Integer> dq = new ArrayDeque<>();       // arraydeque implementation of deque
        
        for (int i = 0; i < len; i++){
            if (!dq.isEmpty() && i - k + 1 > dq.peek()){
                dq.poll();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            
            dq.offer(i);
            if (i >= k-1){
                res[index++] = nums[dq.peek()];
            }
        }
        return res;
    }
}

*/



public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int len = nums.length, index = 0;
        int[] res = new int[len-k+1];
        Deque<Integer> dq = new LinkedList<>();      // linked list implementation of deque
        
        for (int i = 0; i < len; i++){
            if (!dq.isEmpty() && i - k + 1 > dq.peek()){
                dq.poll();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            
            dq.offer(i);
            if (i >= k-1){
                res[index++] = nums[dq.peek()];
            }
        }
        return res;
    }
}

