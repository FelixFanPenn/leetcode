public class Solution {
    public boolean canFinish(int num, int[][] pre) {
        if (num < 2) return true;
        int[] in = new int[num];
        for (int i = 0; i < pre.length; i++){
            in[pre[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < num; i++){
            if (in[i] == 0) {
                q.offer(i);
                count++;
            }
        }
        
        while (!q.isEmpty()){
            int tmp = q.poll();
            
            for (int i = 0; i < pre.length; i++){
                if (pre[i][1] == tmp) {
                    in[pre[i][0]]--;
                    if (in[pre[i][0]] == 0) {
                        q.offer(pre[i][0]);
                        count++;
                    }
                }
            }
        }
        return count == num;
    }
}