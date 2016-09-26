/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode newhead;
        dummy.next = head;
        newhead = dummy;
        ListNode itr = dummy;
        for (int i = 0; i < n; i++){
            itr = itr.next;
        }
        while(itr.next != null){
            itr = itr.next;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return newhead.next;
    }
}
