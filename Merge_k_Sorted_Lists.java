/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        return binaryMerge(lists, 0, lists.length-1);
    }
    
    private ListNode binaryMerge(ListNode[] lists, int low, int high){  // O(nlogk) --> n is the number of listnodes and k is the length of lists
        if (low == high) return lists[low];
        int mid = (low+high)/2;
        
        // Divide and conquer
        ListNode l1 = binaryMerge(lists, mid+1, high);
        ListNode l2 = binaryMerge(lists, low, mid);
        
        // Merge list
        ListNode dummy = new ListNode(0);
        ListNode begin = dummy;
        
        while(l1 != null && l2 != null){
            if (l1.val > l2.val){
                begin.next = l2;
                l2 = l2.next;
            } else {
                begin.next = l1;
                l1 = l1.next;
            }
            begin = begin.next;
        }
        if (l1 != null) begin.next = l1;
        if (l2 != null) begin.next = l2;
        
        return dummy.next;
    }
    
    
    /*
    private ListNode merge2(ListNode head1, ListNode head2){  //O(nk)
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;
        
        while(head1 != null && head2 != null){
            if (head1.val > head2.val){
                itr.next = head2;
                head2 = head2.next;
            } else {
                itr.next = head1;
                head1 = head1.next;
            }
            itr = itr.next;
        }
        if (head1 != null) itr.next = head1;
        if (head2 != null) itr.next = head2;
        return dummy.next;
    }
    */
}
