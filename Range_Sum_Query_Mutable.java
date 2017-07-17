public class NumArray {
    
    int[] BIT;
    int[] num;
    int len;
    public NumArray(int[] nums) {
        len = nums.length;
        num = nums;
        BIT = new int[len+1];
        
        for (int i = 0; i < len; i++) 
            init(i, num[i]);
    }
    
    public void init(int i, int val) {
        i++;
        while (i <= len) {
            BIT[i] += val;
            i += (i & -i);
        }
    }
    
    public void update(int i, int val) {
        int dif = val - num[i];
        num[i] = val;
        init(i, dif);
    }
    
    public int getSum(int n) {
        int res = 0; n++;
        while (n > 0) {
            res += BIT[n];
            n -= (n & -n);
        }
        return res;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */