//copy linked List with random pointer

// no extra space!!!
public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode mover = head;
    while (mover != null) {
        RandomListNode copy = new RandomListNode(mover.label);
        RandomListNode next = mover.next;
        mover.next = copy;
        copy.next = next;
        mover = copy.next;
    }
    RandomListNode fakeHead = new RandomListNode(0);
    RandomListNode copyMover = fakeHead;
    mover = head;
    while (mover != null) {
        if (mover.random != null) {
            mover.next.random = mover.random.next;
        }
        mover = mover.next.next;
    }
    mover = head;
    while (mover != null) {
        copyMover.next = mover.next;
        mover.next = mover.next.next;
        mover = mover.next;
        copyMover = copyMover.next;
    }
    return fakeHead.next;
}