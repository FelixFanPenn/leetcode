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
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        
        TreeNode node = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
            node.left = sortedListToBST(head);
        }
        node.right = sortedListToBST(slow.next);
        
        return node;
        
    }
    
}

/*
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = null;
        ListNode head2 = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        head2 = slow.next;
        TreeNode root = new TreeNode(slow.val);
        
        if (pre == null) {
            root.right = sortedListToBST(head2);
            root.left = sortedListToBST(pre);
        } else {
            pre.next = null;
            root.right = sortedListToBST(head2);
            root.left = sortedListToBST(head);
        }
        return root;

    }
}
*/
