public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            while (!stack.isEmpty() && stack.peek() < i){
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++){
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        return res;
    }
}
/*
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        init(q, nums);
        return search(q, findNums);
    }
    
    public void init(Queue<Integer> q, int[] nums){
        for (int i : nums){
            q.offer(i);
        }
    }
    
    public int[] search(Queue<Integer> q, int[] findNums){
        int[] res = new int[findNums.length];
        
        for (int i = 0; i < findNums.length; i++){
            Queue<Integer> q1 = new LinkedList<Integer>();
            q1.addAll(q);
            while (!q1.isEmpty()){
                int j = q1.poll();
                if (j != findNums[i]) continue;
                else {
                    if (q1.isEmpty()){
                        res[i] = -1;
                        break;
                    } else {
                        boolean found = false;
                        while (!q1.isEmpty()){
                            int num = q1.poll();
                            if (num > j) {
                                res[i] = num;
                                found = true;
                                break;
                            }
                        }
                        if (!found) res[i] = -1;
                        break;
                    }
                }
            }
        }
        return res;
    }
}

*/