public boolean isSymmetric(TreeNode root) {
	if (root == null) return null;
	Stack<TreeNode> left = new Stack<>();
	Stack<TreeNode> right = new Stack<>();
	left.push(root.left);
	right.push(root.right);

	while (!left.isEmpty() && !right.isEmpty()) {
		TreeNode ltmp = left.pop();
		TreeNode rtmp = right.pop();
		if (ltmp == null && rtmp == null) continue;
		if (ltmp != null && rtmp != null) {
			if (ltmp.val != rtmp.val) return false;
			left.push(left.right);
			left.push(left.left);
			right.push(right.left);
			right.push(right.right);
		} else {
			return false;
		}
	}
	return true;
}