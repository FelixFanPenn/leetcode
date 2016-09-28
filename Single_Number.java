public class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            num ^= nums[i];
        }
        return num;
    }
}

/*
or use hashmap<nums[i], appearance>

for ( String key : team1.keySet() ) {
    get every key and then check appearance for each key
}
*/
