/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private TreeNode node;
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if (!stack.isEmpty()){
            stack.pop();
        }
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        node = stack.peek();
        stack.pop();
        
        TreeNode res = node;
        node = node.right;
        return res.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
