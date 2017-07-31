public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] + a[1] - b[0] - b[1];
            }
        });
    
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] tmp = new int[2];
                tmp[0] = nums1[i]; tmp[1] = nums2[j];
                p.offer(tmp);
            }
        }
    
        while (k > 0 && !p.isEmpty()) {
            res.add(p.poll());
            k--;
        }
        return res;
    }
}