public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        class Struct{
            int row;
            int col;
            int num;
            Struct(int i, int j, int k){
                row = i;
                col = j;
                num = k;
            }
        }
        
        PriorityQueue<Struct> queue = new PriorityQueue<Struct>(new Comparator<Struct>(){
           @Override
           public int compare(Struct s1, Struct s2){
               return s1.num - s2.num;
           }
        });
        
        for (int i = 0; i < matrix[0].length; i++){
            Struct s = new Struct(0, i, matrix[0][i]);
            queue.offer(s);
        }
        
        int count = 0;
        while(count < k - 1){
            Struct s = queue.poll();
            if (s.row+1 < matrix.length){
                Struct n = new Struct(s.row+1, s.col, matrix[s.row+1][s.col]);
                queue.offer(n);
            }
            count++;
        }
        return queue.poll().num;
    }
}
