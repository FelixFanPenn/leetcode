public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int first = 0, second, third;
        int count = 0;
        Arrays.sort(nums);
        
        while(first < nums.length-2){
            second = first + 1;
            third = nums.length - 1;
            while(second < third){
                if (target > nums[first] + nums[second] + nums[third]){
                    count += third - second;   /// count them all
                    second++;
                } else {
                    third--;
                }
            }
            first++;
        }
        return count;
    }
}
