public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int count = 0;
        for (int i : nums){
            int val = i - k;
            if (set1.contains(val) && !set2.contains(i + "," + val)){
                count++;
                set2.add(i + "," + val);
            }
            
            set1.add(i);
        }
        return count;
    }
}