/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode itr = dummy;
        
        while (itr.next != null){
            if (itr.next.val == val){
                itr.next = itr.next.next;
            } else {
                itr = itr.next;
            }
        }
        
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
