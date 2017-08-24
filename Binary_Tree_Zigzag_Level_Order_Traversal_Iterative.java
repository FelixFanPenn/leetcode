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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
        List<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
        */
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }
    
    /*
    public void helper(TreeNode root, List<List<Integer>> list, int level){
        if (root == null) return;
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        
        if (level % 2 == 0){
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0, root.val);
        }
        
        helper(root.left, list, level+1);
        helper(root.right, list, level+1);
    }
    */
}