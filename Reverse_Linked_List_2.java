/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
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
*/

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        
        ListNode head1 = new ListNode(0);
        ListNode itr = head1;
        itr.next = head;
        ListNode tail1;
        ListNode head2;
        ListNode tail2;
        ListNode head3;
        int i = 1;
        
        while (m > i){
            i++;
            itr = itr.next;
        }
        
        head2 = itr.next;
        tail1 = itr;
        tail1.next = null;
        
        int dif = n - m;
        itr = head2;
        
        while (dif > 0 && itr != null){
            dif--;
            itr = itr.next;
        }
        
        head3 = itr.next;
        tail2 = itr;
        tail2.next = null;
        
        reverse(head2);
        
        tail1.next = tail2;
        head2.next = head3;
        return head1.next;
        
    }
    
    public void reverse(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
    }
}
