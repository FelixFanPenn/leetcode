/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next, fast = head.next.next;  // look into how they are initialized!!
        
        while(fast != null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (slow != fast) return null;
        fast = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
