public class Solution {
    
    class Node{
        int sum, val, dup = 1;
        Node left = null, right = null;
        Node(int sum, int val){
            this.sum = sum;
            this.val = val;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length-1; i >= 0; i--){
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null){
            node = new Node(0, num);
            ans[i] = preSum;
        } else if (node.val == num){
            node.dup++;
            ans[i] = node.sum + preSum;
        } else if (node.val > num){
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else if (node.val < num){
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}
