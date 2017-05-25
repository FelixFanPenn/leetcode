public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = 0;
        for (int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            
            // http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(int[],%20int)
            // for binarySearch:
            // index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). 
            // The insertion point is defined as the point at which the key would be inserted into the array: 
            // the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. 
            // Note that this guarantees that the return value will be >= 0 if and only if the key is found.
            //
            //
            
            if (index < 0) {
                index = -(index+1);
            }
            int cand1 = index >= 1 ? house - heaters[index-1] : Integer.MAX_VALUE;
            int cand2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            max = Math.max(max, Math.min(cand1, cand2));
        }
        
        return max;
    }
}