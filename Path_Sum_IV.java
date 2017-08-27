class Solution {

    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();
    
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }
        
        traverse(nums[0] / 10, 0);
        
        return sum;
    }
    
    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        
        int curSum = preSum + tree.get(root);
        
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }
        
        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }
    
    /*
    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i / 10, i % 10);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            int n = nums[i];
            int d = n / 100;
            int pos = n % 100 / 10;
            if (!map.containsKey((d + 1) * 10 + pos * 2) && !map.containsKey((d + 1) * 10 + pos * 2 - 1)) {
                list.add(n);
            }
        }
        
        int sum = 0;
        
        for (int n : nums) {
            if (list.contains(n)) {
                int d = n / 100;
                int pos = n % 100 / 10;
                int val = n % 10;
                while (d != 0) {
                    sum += val;
                    d--;
                    if (d == 0) break;
                    if (pos % 2 == 0) pos /= 2;
                    else pos = (pos + 1) / 2;
                    
                    val = map.get(d * 10 + pos);
                }
            }
        }
        
        return sum;
    }
    */
}