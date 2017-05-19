public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        
        for (int i = 1; i < len; i++){
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++){
                int val = triangle.get(i).get(j);
                if (j == 0){
                    triangle.get(i).set(0, val + triangle.get(i-1).get(0));
                } else if (j == size-1){
                    triangle.get(i).set(j, val + triangle.get(i-1).get(j-1));
                } else {
                    int val1 = triangle.get(i-1).get(j-1);
                    int val2 = triangle.get(i-1).get(j);
                    triangle.get(i).set(j, val + Math.min(val1, val2));
                }
            }
        }
        
        return findMin(triangle.get(len-1));
    }
    
    public int findMin(List<Integer> res){
        int min = Integer.MAX_VALUE;
        for (int i : res){
            min = Math.min(min, i);
        }
        return min;
    }
}