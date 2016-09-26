/**
 Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newhead = new ListNode(0);

        while(head != null){
            ListNode dummy = newhead;
            ListNode behind = head.next;
            while(dummy.next != null && dummy.next.val < head.val){
                dummy = dummy.next;
            }
            head.next = dummy.next;
            dummy.next = head;
            head = behind;
        }
        return newhead.next;
    }
}
