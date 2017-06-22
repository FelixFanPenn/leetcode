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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        String result = t.val + "";
        
        if (t.left == null && t.right == null) return result;
        if (t.left == null) return result + "()(" + right + ")";
        if (t.right == null) return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
*/
public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(sb,t);
        return sb.toString();
    }
    public void helper(StringBuilder sb,TreeNode t){
        if(t!=null){
            sb.append(t.val);
            if(t.left!=null||t.right!=null){
                sb.append("(");
                helper(sb,t.left);
                sb.append(")");
                if(t.right!=null){
                    sb.append("(");
                    helper(sb,t.right);
                    sb.append(")");
                }
            }
        }
    }
}