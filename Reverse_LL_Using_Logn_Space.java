//'Time complexity: O(nlgn) space complexity: O(lgn)'
class ReversePrint {
    public void print(ListNode head) {
        ListNode mover = head;
        int length = 0;
        while (mover != null) {
            mover = mover.next;
            length++;
        }
        helper(head, length);
    }

    private void helper(ListNode head, int length) {
        if (head == null) {
            return;
        }
        if (length == 1) {
            System.out.println(head.val);
            return;
        }
        int count = 0;
        ListNode mover = head;
        while (count < length / 2) {
            mover = mover.next;
            count++;
        }
        helper(mover, length - length / 2);
        helper(head, length / 2);
    }
}
