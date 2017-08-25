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
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean b1 = (s == null) ? false : isSubtree(s.right, t) || isSubtree(s.left, t) ;
        return sameTree(s, t) || b1;
    }
    
    public boolean sameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null && t != null || s != null && t == null) return false;
        return s.val == t.val && sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
    */
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s); 
        String tpreorder = generatepreorderString(t);
        
        return spreorder.contains(tpreorder) ;
    }
    public String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack();
        stack.push(s);
        while(!stack.isEmpty()){
           TreeNode node = stack.pop();
           if(node == null)
              sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
           else      
              sb.append("," + node.val);
           if(node != null){
                stack.push(node.right);    
                stack.push(node.left);  
           }
        }
        return sb.toString();
    }
}