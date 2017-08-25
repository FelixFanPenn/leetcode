// time O(n)
// space O(h)


class TreeNode {
	TreeNode left, right;
	int val;
	TreeNode(int v) {
		val = v;
	}
} 

class Pair {
	TreeNode node;
	int depth;
	Pair(TreeNode node, int depth) {
		this.node = node;
		this.depth = depth;
	}
}

public TreeNode findLCARecursive(TreeNode root) {
	return helper(root).node;
}

public Pair helper(TreeNode node) {
	if (node == null) return new Pair(null, 0);
	Pair l = helper(node.left);
	Pair r = helper(node.right);
	int depth = Math.max(l.depth, r.depth) + 1;
	if (l.depth == r.depth) return new Pair(node, depth);
	else if (l.depth > r.depth) return new Pair(l.node, depth);
	return new Pair(r.node, depth);
}