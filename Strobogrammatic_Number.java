public class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(1, 1);
        map.put(8, 8);
        map.put(0, 0);
        
        int left = 0, right = num.length()-1;
        
        while(left <= right){
            int l = Integer.parseInt(""+num.charAt(left));
            int r = Integer.parseInt(""+num.charAt(right));
            if (map.containsKey(l)){
                if (r == map.get(l)){
                    left++;
                    right--;
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
