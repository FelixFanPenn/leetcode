/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode ret = getMid(head);
        ListNode mid = ret.next;
        ret.next = null;
        ListNode rev = reverse(mid);
        return isPalin(head, rev);
        
    }
    
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode ret = slow;
        while (fast != null && fast.next != null){
            ret = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return ret;
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
    
    public boolean isPalin(ListNode l1, ListNode l2){
        while (l1 != null && l2 != null){
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}

/*
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode pre = null;
        while(slow != null){
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        
        while(pre.next != null && head.next != null){
            if (pre.val != head.val) return false;
            pre = pre.next;
            head = head.next;
        }
        return pre.val == head.val;
    }
}
*/
