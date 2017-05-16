/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode itr = head;
        while (l1 != null || l2 != null){
            int i = 0;
            int j = 0;
            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode((i+j+carry) % 10);
            itr.next = node;
            itr = itr.next;
            
            carry = (i+j+carry) / 10;
        }
        
        if (carry != 0){
            ListNode node = new ListNode(carry);
            itr.next = node;
        }
        return head.next;
        
    }
}