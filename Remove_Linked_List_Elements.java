/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {    /// change the original linked list
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode itr = new ListNode(0);
        ListNode dummy = itr;
        
        while(head.next != null){
            if (head.val != val){
                itr.next = head;
                itr = itr.next;
            }
            head = head.next;
        }
        if (head.val == val) itr.next = null;
        else itr.next = head;
        
        return dummy.next;
    }
}
/*

    ListNode* removeElements(ListNode* head, int val) {   /// preserve the original linked list
        if (!head) return NULL;
        ListNode* newhead = new ListNode(0);
        ListNode* res = newhead;
        
        while (head){
           if (head->val == val){
               head = head->next;
           } else {
               ListNode* node = new ListNode(head->val);
               newhead->next = node;
               newhead = newhead->next;
               head = head->next;
           }
        }
        
        return res->next;

    }

*/
