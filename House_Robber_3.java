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
    public int rob(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }
    
    public int robHelper(TreeNode root, HashMap<TreeNode, Integer> map){
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        
        int num1 = robHelper(root.left, map) + robHelper(root.right, map);
        int num2 = root.val;
        if (root.left != null) {
            num2 += robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }
        
        if (root.right != null) {
            num2 += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }
        
        int sum = num1 > num2 ? num1 : num2;
        map.put(root, sum);
        return sum;
    }
}
 
/*

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        int num1 = rob(root.left) + rob(root.right);
        
        int num2 = root.val;
        if (root.left != null) {
            num2 += rob(root.left.left) + rob(root.left.right);
        }
        
        if (root.right != null) {
            num2 += rob(root.right.left) + rob(root.right.right);
        }
        
        return num1 > num2 ? num1 : num2;
    }
}

*/