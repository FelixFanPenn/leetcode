/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        
        int dif = Math.abs(lenA - lenB);
        
        if (lenA > lenB){
            headA = forward(dif, headA);
        } else {
            headB = forward(dif, headB);
        }
        
        return getIntersection(headA, headB);
        
    }
    
    public int getLen(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    
    public ListNode forward(int steps, ListNode head){
        while (steps != 0){
            head = head.next;
            steps--;
        }
        return head;
    }
    
    public ListNode getIntersection(ListNode headA, ListNode headB){
        while (headA != null && headB != null){
            if (headA.val == headB.val) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}


/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lena = 0, lenb = 0;
        ListNode a = headA, b = headB;
        
        while(a != null){
            lena++;
            a = a.next;
        }
        while(b != null){
            lenb++;
            b = b.next;
        }
        int diff = Math.abs(lena-lenb);
        if (lena > lenb){
            for (int i = 0; i < diff; i++){
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < diff; i++){
                headB = headB.next;
            }
        }
        
        while(headA != null && headB != null && headA != headB){
            headA = headA.next;headB = headB.next;
        }
        
        return headA == headB? headA:null;
        
    }
}
*/
