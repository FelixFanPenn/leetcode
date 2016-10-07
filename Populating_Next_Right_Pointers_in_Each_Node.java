/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        while(level != null){
            TreeLinkNode node = level;
            while(node != null){
                if (node.left != null){
                    node.left.next = node.right;
                }
                if (node.right != null && node.next != null){
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            level = level.left;
        }
    }

}
