public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int pre = 0; 
    
        for (String s : logs) {
            String[] strs = s.split(":");
            int time = Integer.parseInt(strs[2]);
            int func = Integer.parseInt(strs[0]);
            if ("start".equals(strs[1])) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - pre;
                }
                stack.push(func);
                pre = time;
            } else {
                res[stack.pop()] += time - pre + 1;
                pre = time + 1;
            }
        }
    
        return res;
    }
}