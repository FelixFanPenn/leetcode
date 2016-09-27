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
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode itr = head;
        
        while(l2 != null && l1 != null){
            int tmp = l1.val + l2.val + carry;
            ListNode node = new ListNode(tmp % 10);
            itr.next = node;
            itr = itr.next;
            carry = tmp/10;
            l2 = l2.next;
            l1 = l1.next;
        }
        
        while (l1 != null){
            int tmp = l1.val + carry;
            ListNode node = new ListNode(tmp % 10);
            itr.next = node;
            itr = itr.next;
            carry = tmp/10;
            l1 = l1.next;
        }
        
        while (l2 != null){
            int tmp = l2.val + carry;
            ListNode node = new ListNode(tmp % 10);
            itr.next = node;
            itr = itr.next;
            carry = tmp/10;
            l2 = l2.next;
        }
        if (carry != 0) {
             ListNode node = new ListNode(carry);
             itr.next = node;
        }
        return head.next;
    }
}
