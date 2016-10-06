/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null) return head;
        
        ListNode tmp = head;
        int i = 1;
        while(tmp.next != null && i < k){
            tmp = tmp.next;
            i++;
        }
        if (i < k) return head;
        
        i = 1;
        ListNode next = tmp.next;
        
        tmp.next = null;
        tmp = head.next;
        head.next = reverseKGroup(next, k);
        ListNode pre = head;

        while (tmp.next != null){
            next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        tmp.next = pre;
        return tmp;
    }
}
