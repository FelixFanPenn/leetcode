public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (1 + len) * len / 2;
        for (int i = 0; i < len; i++){
            sum -= nums[i];
        }
        return sum;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int res = 0, i = 0;
        
        for (i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res ^ i;
    }
}

/*
a^b^b =a, which means two xor operations with the same number 
will eliminate the number and reveal the original number.
In this solution, I apply XOR operation to both the index and value of the array. 
In a complete array with no missing numbers, the index and value 
should be perfectly corresponding( nums[index] = index), 
so in a missing array, what left finally is the missing number.
*/
