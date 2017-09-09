class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int v) {
        val = v;
    }
}
public class TreeAmplitude {
    public int solution(TreeNode root) {
        if (root == null) return 0;
        return helper(root, root.val, root.val);
    }
    
    public int helper(TreeNode root, int max, int min) {
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        
        return Math.max(helper(root.left, max, min), helper(root.right, max, min));
    }
}
