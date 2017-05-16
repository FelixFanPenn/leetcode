/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 

public class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(mid);
        
        ListNode res = merge(node1, node2);
        return res;
        
    }
    
    
    public ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;
        
        while (l1 != null && l2 != null){
            int i = l1.val;
            int j = l2.val;
            if (i < j){
                itr.next = l1;
                l1 = l1.next;
            } else {
                itr.next = l2;
                l2 = l2.next;
            }
            itr = itr.next;
        }
        
        if (l1 != null) itr.next = l1;
        if (l2 != null) itr.next = l2;
        
        return dummy.next;
        
    }
    
    
}


/*

https://discuss.leetcode.com/topic/10382/bottom-to-up-not-recurring-with-o-1-space-complextity-and-o-nlgn-time-complextity/7
public class Solution {
    ListNode dummyRes = new ListNode(0);
    public class MergeResult {
        ListNode head;
        ListNode tail;
        
        MergeResult(ListNode h, ListNode t) { head = h; tail = t;}
    } 
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        int length = length(head);
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        MergeResult mr = new MergeResult(null, null);
        for(int step = 1; step < length; step <<= 1) {
            ListNode left = dummy.next;
            ListNode prev = dummy;
            while(left != null) {
                ListNode right = split(left, step);
                if(right == null) {
                    prev.next = left;
                    break;
                }
                ListNode next = split(right, step);
                merge(left, right, mr);
                prev.next = mr.head;
                prev = mr.tail;
                left = next;
            }
        }
        
        return dummy.next;
    }
    
    public ListNode split(ListNode head, int step) {
        while(head != null && step != 1) {
            head = head.next;
            step--;
        }
        if(head == null) return null;
        ListNode res = head.next;
        head.next = null;
        return res;
    }
    
    public int length(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        
        return len;
    }
    
    public void merge(ListNode head1, ListNode head2, MergeResult mr) {
        if(head2 == null) {
            mr.head = head1;
            mr.tail = null;
        }
        ListNode res = dummyRes;
        ListNode tail = res;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        while(head1 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }
        
        while(head2 != null) {
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        
        mr.head = res.next;
        mr.tail = tail;
    }
}
*/