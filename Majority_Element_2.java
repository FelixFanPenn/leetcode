public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res;
        
        int count1 = 0, count2 = 0, number1 = nums[0], number2 = nums[0];
        
        for (int num : nums){
            if (num == number1){
                count1++;
            } else if (num == number2){
                count2++;
            } else if (count1 == 0){
                number1 = num;
                count1 = 1;
            } else if (count2 == 0){
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0; count2 = 0;
        for (int num : nums){
            if (num == number1) count1++;
            else if (num == number2) count2++;
        }
        if (count1 > len/3) res.add(number1);
        if (count2 > len/3) res.add(number2);
        return res;
    }
}
