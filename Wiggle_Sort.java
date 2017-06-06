public class Solution {
    public void wiggleSort(int[] nums) {

        for (int i = 1; i < nums.length; i++){
            if (i % 2 == 0 && nums[i] > nums[i-1] || i % 2 == 1 && nums[i] < nums[i-1]) {
                int j = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = j;
            }
        }
    }
}
/*
public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i += 2){
            int j = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = j;
        }
    }
}
*/
/*
public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int index = i;
            for (int j = i; j < nums.length; j++){
                if (i % 2 == 0 && nums[j] < cur) {
                    index = j;
                    cur = nums[j];
                } else if (i % 2 == 1 && nums[j] > cur){
                    index = j;
                    cur = nums[j];
                }
            }
            swap(nums, i, index);
        }
    }
    
    public void swap(int[] nums, int l, int r){
        int i = nums[l];
        nums[l] = nums[r];
        nums[r] = i;
    }
}
*/