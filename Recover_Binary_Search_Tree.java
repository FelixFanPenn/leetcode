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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {       
        if (root == null || root.left == null && root.right == null) return;

        traverse(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

    }
    
    private void traverse(TreeNode root){
        if (root == null) return;
        traverse(root.left);
        
        if (first == null && pre.val >= root.val){
            first = pre;
        }
        
        if (first != null && pre.val >= root.val){
            second = root;
        }
        pre = root;
        
        traverse(root.right);
    }
} 

/*
 
public class Solution {
    public void recoverTree(TreeNode root) {       
        List<TreeNode> bsf = new ArrayList<>();   // inorder traversal of treenodes
        List<Integer> rec = new ArrayList<>(); 
        inOrderTraversal(root, bsf);
        for (TreeNode element: bsf){
            rec.add(element.val);
        }
        //Collections.sort(rec);   
        rec.sort(null);                          // sort the arraylist so it becomes the right order
        for (int i = 0; i < rec.size(); i++){
            bsf.get(i).val = rec.get(i);          // update the int values of treenodes 
        }
        
    }
    
    private void inOrderTraversal(TreeNode root, List<TreeNode> bsf){
        if (root == null) return;
        inOrderTraversal(root.left, bsf);
        bsf.add(root);
        inOrderTraversal(root.right, bsf);
    }
}
*/