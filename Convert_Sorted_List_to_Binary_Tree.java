/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// O(n) time and O(logN) space (bc of recursion)
class Solution {
    private ListNode listnode = null;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode itr = head;
        while (itr != null) {
            size++;
            itr = itr.next;
        }
        listnode = head;
        return inorderhelper(0, size-1);
    }
    
    private TreeNode inorderhelper(int left, int right) {
        if (left > right)
            return null;
        int mid = (right - left) / 2 + left;
        
        TreeNode lc = inorderhelper(left, mid-1);
        
        TreeNode node = new TreeNode(listnode.val);
        listnode = listnode.next;
        
        TreeNode rc = inorderhelper(mid+1, right);
        
        node.left = lc;
        node.right = rc;
        return node;
    }
}