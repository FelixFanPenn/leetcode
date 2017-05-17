/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newHead = new ListNode(0);
        ListNode itr = newHead;
        
        while (head != null){
            
            int cur = head.val;
            int i = 0;
            while (head.next != null && cur == head.next.val){
                head = head.next;
                i++;
            }
            
            if (i == 0) {
                itr.next = head;
                itr = itr.next;
            } else {
                itr.next = null;
            }
            head = head.next;
        }
        
        
        return newHead.next;
    }
}