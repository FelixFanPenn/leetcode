package Iterators;

import java.util.Stack;
/*
class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int v) {
		val = v;
	}
}
*/
public class InorderIterator {
	Stack<TreeNode> stack;
	
	public InorderIterator(TreeNode root) {
		stack = new Stack<>();
		pushToLeft(root);
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		if (!hasNext()) return -1;
		TreeNode node = stack.pop();
		pushToLeft(node.right);
		
		return node.val;
	}
	
	public void pushToLeft(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
