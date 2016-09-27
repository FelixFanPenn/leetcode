/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* 
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        help(root, res);
        return res;
    }
    
    private void help(TreeNode root, List<Integer> res){
        if (root == null) return;
        help(root.left, res);
        help(root.right, res);
        res.add(root.val);
    }
}
*/

/*
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode tmp = q.pop();
            if (tmp != null){
                res.add(tmp.val);
                q.push(tmp.left);
                q.push(tmp.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}

*/


public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();       
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        
        while(!stack1.isEmpty()){
            TreeNode tmp = stack1.pop();
            stack2.push(tmp);
            
            if (tmp.left != null){
                stack1.push(tmp.left);
            }
            
            if (tmp.right != null){
                stack1.push(tmp.right);
            }
        }
        
        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
}

