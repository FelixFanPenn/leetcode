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
        if (root == null) return;
        
        TreeLinkNode node = root.next;
        while (node != null) {
            if (node.left != null) {
                node = node.left;
                break;
            }
            
            if (node.right != null) {
                node = node.right;
                break;
            }
            node = node.next;
        }
        
        if (root.right != null) root.right.next = node;
        if (root.left != null) root.left.next = (root.right == null) ? node : root.right;
        
        connect(root.right);
        connect(root.left);
    }
    
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
	        if (root.left != null) {
		        pre.next = root.left;
		        pre = pre.next;
	        }
    	    if (root.right != null) {
	    	    pre.next = root.right;
		        pre = pre.next;
	        }
    	    root = root.next;
	        if (root == null) {
		        pre = dummyHead;
		        root = dummyHead.next;
		        dummyHead.next = null;
	        }
        }
    }
}