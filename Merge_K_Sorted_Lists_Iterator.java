public ListNode mergeKLists(ListNode[] lists) {
	if (lists.length == 0) return null;

	ListNode fakeHead = new ListNode(-1);
	ListNode mover = fakeHead;
	PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>(){
		@Override
		public int compare(ListNode node1, ListNode node2) {
			return node1.val - node2.val;
		}
	});

	for (ListNode node : lists) {
		q.offer(node);
	}

	while (!q.isEmpty()) {
		ListNode node = q.poll();
		mover.next = node;
		mover = mover.next;
		if (node.next != null) {
			q.offer(node.next);
		}
		mover.next = null;
	}
	return fakeHead.next;
}