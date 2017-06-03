public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        Arrays.fill(height, 0);
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else height[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++){
            int h = (i == heights.length)? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) stack.push(i);
            else {
                int index = stack.pop();
                max = Math.max(max, heights[index] * (stack.isEmpty()? i : i - stack.peek() - 1));
                i--;
            }
        }
        return max;
    }
}
