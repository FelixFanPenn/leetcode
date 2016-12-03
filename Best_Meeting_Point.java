public class Solution {
    public int minTotalDistance(int[][] grid) {  // only the minimum distance
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        return findMin(row) + findMin(col);
    }
    
    private int findMin(ArrayList<Integer> arr){
        Collections.sort(arr);
        int left = 0;
        int right = arr.size()-1;
        int res = 0;
        while(left < right){
            res += arr.get(right) - arr.get(left);
            left++;
            right--;
        }
        return res;
    }
    
    /*  this will also find the location of the best meeting point
    public int minTotalDistance(int[][] grid) {
        ArrayList<int[]> people = new ArrayList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    int[] arr = new int[2];
                    arr[0] = i; arr[1] = j;
                    people.add(arr);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                min = Math.min(min, findDistance(i, j, people));
            }
        }
        return min;
    }
    
    private int findDistance(int i, int j, ArrayList<int[]> people){
        int tmp = 0;
        for (int k = 0; k < people.size(); k++){
            tmp += Math.abs(people.get(k)[0] - i) + Math.abs(people.get(k)[1] - j);
        }
        return tmp;
    }
    */
}
