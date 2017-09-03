/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    class Item {
        int size;
        int lower;
        int upper;
        Item(int s, int l, int u) {
            size = s;
            lower = l;
            upper = u;
        }
    }
    
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root, null);
        return max;
    }
    
    public Item helper(TreeNode root, TreeNode parent) {
        if (root == null) return new Item(0, parent.val, parent.val);
        Item i1 = helper(root.left, root);
        Item i2 = helper(root.right, root);
        if (i1.size == -1 || i2.size == -1 || root.val < i1.upper || root.val > i2.lower) return new Item(-1, 0, 0);
        int size = 1 + i1.size + i2.size;
        
        max = Math.max(max, size);
        return new Item(size, i1.lower, i2.upper);
    }
}
/*
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return count(root);
        }
        
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    public boolean isValid(TreeNode root, int max, int min) {
        if (root == null) return true;
        if (root.val < max && root.val > min) 
            return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
        else return false;
    }
    
    public int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + count(node.left) + count(node.right);
    }
}
*/