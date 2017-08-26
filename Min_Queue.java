
// space O(n) time O(len)

class MinQueue {
	public Queue<Integer> queue = new LinkedList<>();
	public Deque<Integer> min = new ArrayQueue<>();

	public void offer(int val) {
		while (!min.isEmpty() && min.peekLast() > val) {
			min.pollLast();
		}
		min.offer(val);
		queue.offer(val);
	}

	public int poll() {
		int v = queue.poll();
		if (min.peek() == v) {
			min.poll();
		}
		return v;
	}

	public int getMin() {
		return min.peek();
	}
}