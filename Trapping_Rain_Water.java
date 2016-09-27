public class Solution {
    public int trap(int[] height) {          //two pointers
        int left = 0, right = height.length-1;
        int level = 0, res = 0;
        
        while(left < right){
            int tmp = height[left] < height[right] ? height[left++]: height[right--];
            if (level < tmp){
                level = tmp;
            } else {
                res += level - tmp;
            }
        }
        return res;
    }
}
/*

public class Solution {
    public int trap(int[] height) {          // stack
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        while(i < height.length){
            if (stack.isEmpty() || height[stack.peek()] > height[i]) stack.push(i);
            else {
                while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                    int mid = stack.pop();
                    if(!stack.empty()) {
                        int j = stack.peek();
                        res += (i - j - 1) * (Math.min(height[i], height[j]) - height[mid]);
                    }
                }
                stack.push(i);
            }
            i++;
        }
        
        return res;
    }
}
