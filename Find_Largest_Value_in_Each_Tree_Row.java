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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        dfs(root, list, 0);
        return list;
    }
    
    public void dfs(TreeNode root, ArrayList<Integer> list, int level){
        if (root == null) return;
        
        if (level == list.size()){
            list.add(root.val);
        } else {
            if (root.val > list.get(level)) {
                list.remove(level);
                list.add(level, root.val);
            }
        }
        
        dfs(root.left, list, level+1);
        dfs(root.right, list, level+1);
    }
    
}