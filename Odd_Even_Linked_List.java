

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode oddTail = odd;
        
        
        while (even != null && even.next != null){
            
            oddTail.next = oddTail.next.next;
            oddTail = oddTail.next;
            
            even.next = even.next.next;
            even = even.next;
        }
        
        oddTail.next = evenHead;
        
        return odd;
    }
    
}

/*
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        int i = 0;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
*/