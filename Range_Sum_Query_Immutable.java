public class NumArray {
    
    ArrayList<Integer> sum = new ArrayList<>();
    public NumArray(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++){
            s += nums[i];
            sum.add(s);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return sum.get(j);
        else {
            return sum.get(j) - sum.get(i-1);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
