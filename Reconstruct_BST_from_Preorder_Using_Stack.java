// time and space O(N)

public TreeNode buildTree(int[] pre) {
	if (pre.length == 0) return null;
	TreeNode node = new TreeNode(pre[0]);
	Stack<TreeNode> stack = new Stack<>();
	stack.push(node);

	for (int i = 1; i < size(); i++) {
		TreeNode tmp = null;
		while (!stack.isEmpty() && pre[i] > stack.peek().val) {
			tmp = stack.pop();
		}

		if (tmp != null) {
			tmp.right = new TreeNode(pre[i]);
			stack.push(tmp.right);
		}

		else {
			tmp = stack.peek();
			tmp.left = new TreeNode(pre[i]);
			stack.push(tmp.left);
		}
	}

	return root;
}


// NLOGN

// FIND THE FIRST VALUE LARGER THAN ITSELF, WHICH IS ITS RIGHT CHILD