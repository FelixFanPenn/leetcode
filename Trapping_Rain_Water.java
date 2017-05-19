
public class Solution {
    
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        int water = 0, i = 0, index = 0;
        
        while (i < len){
            if (stack.isEmpty() || height[stack.peek()] >= height[i]){
                stack.push(i++);
            } else {
                index = stack.pop();
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    int h = Math.min(height[i], height[stack.peek()]) - height[index];
                    water += w * h;
                }

            }
        }
        return water;
    }
    
}

/*
public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0;
        int water = 0, max = height[0], index = 0;
        
        for (int i = 0; i < len; i++){
            if (max < height[i]){
                index = i;
                max = height[i];
            }
        }
        
        int cur = height[0];
        for (int i = 1; i < index; i++){
            if (height[i] < cur) {
                water += cur - height[i];
            } else {
                cur = height[i];
            }
        }
        
        cur = height[len-1];
        for (int i = len-1; i > index; i--){
            if (height[i] < cur) {
                water += cur - height[i];
            } else {
                cur = height[i];
            }
        }
        return water;
    }
}
*/
