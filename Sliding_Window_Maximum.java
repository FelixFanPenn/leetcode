public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int len = nums.length, index = 0;
        int[] res = new int[len-k+1];
        Deque<Integer> dq = new LinkedList<>();      // linked list implementation of deque
        
        for (int i = 0; i < len; i++){
            // if the first element in current queue is already outside of the range
            // need to discard it
            if (!dq.isEmpty() && i - k + 1 > dq.peek()){
                dq.poll();
            }

            //starting from the back, if the number if less than current number, discard them
            //they cannot be maximum in any window from now on
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            
            // store index but not values
            dq.offer(i);
            if (i >= k-1){
                res[index++] = nums[dq.peek()];
            }
        }
        return res;
    }
}

