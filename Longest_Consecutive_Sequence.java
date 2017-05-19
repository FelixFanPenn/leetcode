public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums){
            
            if (!map.containsKey(i)){
                int left = map.containsKey(i-1) ? map.get(i-1) : 0;
                int right = map.containsKey(i+1) ? map.get(i+1) : 0;
                int len = left + right + 1;
                
                map.put(i, len);
                
                max = Math.max(max, len);
                
                map.put(i - left, len);
                map.put(i + right, len);
                
            }
            
        }
        
        return max;
    }
}

/*
public class Solution {   // union find solution
    
    class Range{
        int low;
        int high;
        public Range(int l, int h){
            this.low = l;
            this.high = h;
        }
    }
    
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Range> rangeMap = new HashMap<>();
        int max = 0;
        
        for (int num: nums){
            if (rangeMap.containsKey(num)) continue;
            Range range = new Range(num, num);
            boolean hasPrev = rangeMap.containsKey(num-1);
            boolean hasNext = rangeMap.containsKey(num+1);
            
            if (hasPrev){
                range.low = rangeMap.get(num-1).low;
            }
            
            if (hasNext){
                range.high = rangeMap.get(num+1).high;
            }
            
            rangeMap.put(num, range);
            rangeMap.put(range.low, range);
            rangeMap.put(range.high, range);
            max = Math.max(max, range.high - range.low + 1);
        }
        return max;
    }
}
*/
