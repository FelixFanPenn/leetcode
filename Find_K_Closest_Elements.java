public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j) {
                int a = Math.abs(i - x);
                int b = Math.abs(j - x);
                if (a != b) return a - b;
                else {
                    return i - j;
                }
            }
        });
        
        for (Integer i : arr) {
            p.offer(i);
        }
        
        List<Integer> res = new ArrayList<>();
    
        while (k > 0) {
            k--;
            res.add(p.poll());
        }
        Collections.sort(res);
        return res;
    }
}