public TreeNode findLCA(TreeNode root, int v1, int v2) {
	if (root == null) return null;
	if (root.val > Math.max(v1, v2)) {
		return findLCA(root.left, v1, v2);
	} else if (root.val < Math.min(v1, v2)) {
		return findLCA(root.right, v1, v2);
	}
	return root;
}