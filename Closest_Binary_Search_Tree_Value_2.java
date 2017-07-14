/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> pred = new Stack<>();
        Stack<Integer> succ = new Stack<>();
        
        // pred only has elements smaller than it 
        // succ only has larger
        
        inorder(pred, true, root, target);
        inorder(succ, false, root, target);
        
        while (k-- > 0) {
            if (pred.isEmpty()) {
                res.add(succ.pop());
            } else if (succ.isEmpty()) {
                res.add(pred.pop());
            } else if (Math.abs(pred.peek() - target) > Math.abs(succ.peek() - target)) {
                res.add(succ.pop());
            } else {
                res.add(pred.pop());
            }
        }
        
        return res;
    }
    
    public void inorder(Stack<Integer> stack, boolean reverse, TreeNode root, double target) {
        if (root == null) return;
        
        inorder(stack, reverse, reverse ? root.right : root.left, target);
        
        if (reverse && root.val <= target || !reverse && root.val > target) return;     // get rid of elements that don't belong to this stack
        stack.push(root.val);
        
        inorder(stack, reverse, reverse ? root.left : root.right, target);
    }
}