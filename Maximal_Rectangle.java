public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        Arrays.fill(height, 0);
        
        for (int i = 0; i < matrix.length; i++){
            height = resetHeight(matrix, i, height);
            maxArea = Math.max(maxArea, largestInRow(height));
        }
        return maxArea;
    }
    
    private int[] resetHeight(char[][] matrix, int row, int[] height){
        for (int i = 0; i < matrix[row].length; i++){
            if (matrix[row][i] == '0'){
                height[i] = 0;
            } else if (matrix[row][i] == '1'){
                height[i] += 1;
            }
        }
        return height;
    }
    
    private int largestInRow(int[] height){
        if(height == null || height.length == 0) return 0;
        int len = height.length, maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i <= len; i++){
            int h = (i == len)? 0: height[i];
            
            if (stack.isEmpty() || height[stack.peek()] <= h){
                stack.push(i);
            } else {
                int tmp = stack.pop();
                maxArea = Math.max(maxArea, height[tmp] * (stack.isEmpty()? i : (i - 1 - stack.peek())));
                i--;
            }
        }
        return maxArea;
    }
}
