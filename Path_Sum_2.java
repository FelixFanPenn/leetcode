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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        ArrayList<Integer> arr = new ArrayList<>();
        help(root, sum, arr, res);
        return res;
    }
    
    private void help(TreeNode root, int sum, ArrayList<Integer> arr, List<List<Integer>> res){
        if (root == null) return;
        arr.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            ArrayList<Integer> a = new ArrayList<>();    // create a new arraylist !!!!
            a.addAll(arr);
            res.add(a);
        } else {
            help(root.left, sum-root.val, arr, res);
            help(root.right, sum-root.val, arr, res);
        }
        arr.remove(arr.size()-1);    //  be careful of where you put this.
        return;
    }
}
