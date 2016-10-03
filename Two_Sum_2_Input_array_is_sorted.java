public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        
        while(low < high){
            long res = numbers[low] + numbers[high];
            if (res == target){
                return new int[]{low + 1, high + 1};
            } else if (res > target){
                high--;
            } else {
                low++;
            }
        }
        return null;
    }
}
