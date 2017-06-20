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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
    
}

 
/* my way
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        plus(root, list);
        return root;
    }
    
    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        preOrder(root.left, list);
        list.add(root.val);
        preOrder(root.right, list);
    }
    
    public void plus(TreeNode root, List<Integer> list) {
        if (root == null) return;
        int l = 0, r = list.size()-1;
        
        int s = -1;
        
        while (l + 1 < r) {
            int mid = (l+r) / 2;
            int m = list.get(mid);
            if (m > root.val) r = mid;
            else if (m < root.val) l = mid;
            else {
                s = mid;
                break;
            }
        }
        if (s == -1) {
            s = list.get(l) == root.val ? l : r;
        }
        
        for (int i = s+1; i < list.size(); i++) {
            root.val += list.get(i);
        }
        plus(root.left, list);
        plus(root.right, list);
    }
}
*/