public class Solution {
    public void wiggleSort(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i += 1){
            res[i] = nums[i];
        }
        Arrays.sort(res);
        int mid = (nums.length - 1) / 2;
        int end = nums.length-1;
        
        for (int i = 0; i < nums.length; i += 1) {
            if (i % 2 == 0) {
                nums[i] = res[mid--];
            } else {
                nums[i] = res[end--];
            }
        }
    }
}