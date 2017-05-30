public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        for (int i = 0; i < (1 << n); i++){
            res.add(i ^ (i >> 1));
        }
        
        return res;
    }
}