// AVG O(N) WORST CASE O(N^2)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, nums.length - k, 0, nums.length-1);
    }
    
    public int partition(int[] nums, int k, int left, int right) {
        int pivot = nums[right], index = left;
        
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, index++, i);
            }
        }
        swap(nums, index, right);
        
        if (index == k) return nums[index];
        if (index > k) return partition(nums, k, left, index-1);
        else return partition(nums, k, index+1, right);
    }
    
    public void swap(int[] nums, int l, int r) {
        int val = nums[l];
        nums[l] = nums[r];
        nums[r] = val;
    }
}

// O(N lg N) running time + O(1) memory
public int findKthLargest(int[] nums, int k) {
    final int N = nums.length;
    Arrays.sort(nums);
    return nums[N - k];
}

//O(N lg K) running time + O(K) memory
public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}