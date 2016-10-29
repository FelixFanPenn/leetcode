public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums1.length; i++){
            if (!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i])+1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0){
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
}
