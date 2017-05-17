/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;
        
        int len;
        for (len = 0; fast.next != null; len++){
            fast = fast.next;
        }
        k = k % len;
        if (k == 0) return head;
        
        for (int j = len - k % len; j > 0; j--) //Get the i-n%i th node
    	    slow = slow.next;
        
        ListNode res = slow.next;
        slow.next = null;
        fast.next = newHead.next;
        return res;
        
    }
}