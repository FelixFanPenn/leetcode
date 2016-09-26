/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode l = new ListNode(0);
        ListNode itr1 = l;
        ListNode s = new ListNode(0);
        ListNode itr2 = s;
        
        while(head != null){
            if (head.val < x){
                itr1.next = head;
                itr1 = itr1.next;
            } else {
                itr2.next = head;
                itr2 = itr2.next;
            }
            head = head.next;
        }
        itr2.next = null;    // important
        itr1.next = s.next;
        return l.next;
    }
}
