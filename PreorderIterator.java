package Iterators;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int v) {
		val = v;
	}
}

public class PreorderIterator {
	
	Stack<TreeNode> stack;
	public PreorderIterator(TreeNode root) {
		stack = new Stack<>();
		if (root == null) return;
		stack.push(root);
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		if (!hasNext()) return -1;
		
		TreeNode node = stack.pop();
		if (node.right != null) stack.push(node.right);
		if (node.left != null) stack.push(node.left);
		
		return node.val;
	}
}
