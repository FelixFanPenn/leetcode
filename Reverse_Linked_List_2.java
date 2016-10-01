/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode itr = new ListNode(0);
        ListNode cur = itr, last = null, pre = null, first = null, second = null;
        itr.next = head;
        
        for (int i = 0; i <= n; i++){

            if (i == m - 1){
                first = cur;
                cur = cur.next;
            } else if (i > m - 1){
                if (i == n) { second = cur; }
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            } else {
                cur = cur.next;
            }
        }
        
        first.next.next = cur;
        first.next = second;
        return itr.next;
    }
}
