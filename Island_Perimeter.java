
public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0, neighbor = 0;
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    count++;
                    if (i < grid.length-1 && grid[i+1][j] == 1) neighbor++;
                    if (j < grid[0].length-1 && grid[i][j+1] == 1) neighbor++;
                }
            }
        }
        return count * 4 - neighbor * 2;
    }
}

/*
public class Solution {
    public int islandPerimeter(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    set.add(i + "," + j);
                }
            }
        }
        int p = 0;
        for (String str : set){
            int f = Integer.parseInt(str.split(",")[0]);
            int s = Integer.parseInt(str.split(",")[1]);
            int count = 0;
            if (!set.contains((f+1) + "," + s)){
                count++;
            }
            if (!set.contains((f-1) + "," + s)){
                count++;
            }
            if (!set.contains(f + "," + (s+1))){
                count++;
            }
            if (!set.contains(f + "," + (s-1))){
                count++;
            }
            p += count;
        }
        return p;
    }
}
*/