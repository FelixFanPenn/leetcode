// O(NLOGN)
public TreeNode Tree2LinkedList(TreeNode root){
	if (root == null) return null;
	connect(root);

	TreeNode head = root;
	TreeNode tail = root;
	while (head.left != null) {
		head = head.left;
	}

	while (tail.right != null) {
		tail = tail.right;
	}
	head.left = tail;
	tail.right = head;
	return head;
}

public void connect(TreeNode node) {
	if (root == null) {
		return;
	}

	if (root.left != null) {
		TreeNode left = root.left;
		connect(left);
		while (left.right != null) {
			left = left.right;
		}
		left.right = root;
		root.left = left;
	}

	if (root.right != null) {
		TreeNode right = root.right;
		connect(right);
		while (right.left != null) {
			right = right.left;
		}
		right.right = root;
		root.left = right;
	}
}