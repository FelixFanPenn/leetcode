class TreeNode {
	List<TreeNode> children;
	int val;
	TreeNode(int v) {
		val = v;
		children = new ArrayList<>();
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

public TreeNode findLCA(TreeNode root) {
	return helper(root).node;
}

public Pair helper(TreeNode node) {
	if (node == null) return new Pair(null, 0);
	if (node.children.isEmpty()) return new Pair(node, 1);

	Pair can1 = new Pair(null, Integer.MIN_VALUE);
	Pair can2 = new Pair(null, Integer.MIN_VALUE);
	for (TreeNode tmp : node.children) {
		Pair p = helper(tmp);
		if (p.depth >= can1.depth) {
			can2.depth = can1.depth;
			can2.node = can1.node;
			can1.depth = p.depth;
			can1.node = p.node;
		}
	}

	if (can1.depth == can2.depth) return new Pair(node, can1.depth+1);
	else return new Pair(can1.node, can1.depth+1);
}
