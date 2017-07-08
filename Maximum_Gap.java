public class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        if (len < 2) return 0;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int gap = (int)Math.ceil((double)(max - min)/(len - 1));
        int[] maxBuc = new int[len];
        int[] minBuc = new int[len];
        Arrays.fill(maxBuc, Integer.MIN_VALUE);
        Arrays.fill(minBuc, Integer.MAX_VALUE);
        
        for (int i : nums) {
            if (i == min || i == max) continue;
            int group = (i - min) / gap;
            maxBuc[group] = Math.max(maxBuc[group], i);
            minBuc[group] = Math.min(minBuc[group], i);
        }
        
        int pre = min, maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < len-1; i++) {
            if (maxBuc[i] == Integer.MIN_VALUE && minBuc[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            maxGap = Math.max(maxGap, minBuc[i] - pre);
            pre = maxBuc[i];
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}