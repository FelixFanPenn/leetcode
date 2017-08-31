class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }
        
        long l = max, r = sum;
        while (l <= r) {
            long mid = (r + l) / 2;
            if (binarySearch(nums, mid, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return (int)l;
    }
    
    public boolean binarySearch(int[] nums, long target, int m) {
        long count = 1, sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum > target) {
                count++;
                sum = i;
                if (count > m) return false;
            }
        }
        return true;
    }
}

The answer is between maximum value of input array numbers and sum of those numbers.
Use binary search to approach the correct answer. We have l = max number of array; 
r = sum of all numbers in the array;Every time we do mid = (l + r) / 2;
Use greedy to narrow down left and right boundaries in binary search.
3.1 Cut the array from left.
3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is large enough 
but still less than mid.
3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
If we can, it means that the mid value we pick is too small because we've already tried our best to 
make sure each part holds as many non-negative numbers as we can but we still have numbers left. 
So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid. 
We should increase m. This leads to l = mid + 1;
If we can't, it is either we successfully divide the array into m parts and 
the sum of each part is less than mid, or we used up all numbers before we reach m. 
Both of them mean that we should lower mid because we need to find the minimum one. 
This leads to r = mid - 1;