public int findMinDepth(TreeNode root) {
	if (root == null) return 0;
	int res = 0;
	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);

	while (!q.isEmpty()) {
		res++;
		int size = q.size();
		for (int i = 0; i < size; i++) {
			TreeNode node = q.poll();
			if (node.left != null && node.right != null) return res;
			if (node.left != null) {
				q.offer(node.left);
			}

			if (node.right != null) {
				q.offer(node.right);
			}
		}
	}
	return -1;
}