/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        } else {
            ListNode tmp = head.next;
            head.next = swapPairs(tmp.next);
            tmp.next = head;
            return tmp;
        }
    }
}
