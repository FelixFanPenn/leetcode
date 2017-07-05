public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> mapIndex = new HashMap<>();
        List<String> res = new LinkedList<>();
        
        for (int i = 0; i < list1.length; i++) {
            mapIndex.put(list1[i], i);
        }
        
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer j = mapIndex.get(list2[i]);
            if (j != null && i + j < minSum) {
                res = new LinkedList<>(); 
                minSum = i + j;
            }
            if (j != null && minSum == i + j) res.add(list2[i]);
        }
        return res.toArray(new String[res.size()]);
    }
}