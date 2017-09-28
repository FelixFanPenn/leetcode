/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        traverse(root, res, "");
        return res;
    }
    
    public void traverse(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }
        
        traverse(root.left, res, s + root.val + "->");
        
        traverse(root.right, res, s + root.val + "->");
        
    }
}

//BFS
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        q1.offer(root); q2.offer("");
        
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            String cur = q2.poll();
            
            if (node.left == null && node.right == null) {
                res.add(cur + node.val);
            }
            
            if (node.left != null) {
                q1.offer(node.left);
                q2.offer(cur + node.val + "->");
            }
            
            if (node.right != null) {
                q1.offer(node.right);
                q2.offer(cur + node.val + "->");
            }
        }
        
        return res;
    }
}

//DFS
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        
        s1.push(root); s2.push("");
        
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            String cur = s2.pop();
            
            if (node.left == null && node.right == null) {
                res.add(cur + node.val);
            }
            
            if (node.left != null) {
                s1.push(node.left);
                s2.push(cur + node.val + "->");
            }
            
            if (node.right != null) {
                s1.push(node.right);
                s2.push(cur + node.val + "->");
            }
        }
        
        return res;
    }
}
