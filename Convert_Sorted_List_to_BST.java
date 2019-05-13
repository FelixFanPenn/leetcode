class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
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