// only O(n) TIME

TreeNode root;
TreeNode head;	// head has the starting element
TreeNode pre = null;

public BT2DLL(TreeNode root) {
	if (root == null) return;
	BT2DLL(root.left);

	if (pre == null) {
		head = root;
	} else {
		root.left = pre;
		pre.right = root;
	}
	pre = root;

	BT2DLL(root.right);
}