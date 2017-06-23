public class Solution {
    public boolean verifyPreorder(int[] p) {
        /*
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
 
        for (int i = 0; i < p.length; i++) {
            if (i == 0) stack.push(p[i]);
            else {
                if (low > p[i]) return false;
                while (!stack.isEmpty() && stack.peek() < p[i]) {
                    low = stack.pop();
                }
                stack.push(p[i]);
            }
        }
        return true;
        */
        int low = Integer.MIN_VALUE, i = -1;
        
        for (int j = 0; j < p.length; j++) {
            if (p[j] < low) return false;
            while (i >= 0 && p[j] > p[i]) {
                low = p[i];
                i--;
            }
            p[++i] = p[j];
        }
        
        return true;
    }
}