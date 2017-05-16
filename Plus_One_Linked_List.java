/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode rev = reverse(head);
        rev = addOne(rev);
        
        return reverse(rev);
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
    
    public ListNode addOne(ListNode head){
        int carry = 1;
        ListNode newHead = head;
        ListNode pre = head;
        
        while (head != null){
            int val = (head.val + carry);
            head.val = val % 10;
            carry = val / 10;
            pre = head;
            head = head.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        
        return newHead;
    }
}
