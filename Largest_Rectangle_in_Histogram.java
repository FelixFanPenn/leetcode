public class Solution {
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

