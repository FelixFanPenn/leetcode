public int findLongest(TreeNode root) {
	Pair p = checkNode(root);
	return p.longestPath;
}

public Pair checkNode(TreeNode node) {
	if (node == null) return new Pair(0, 0);
	Pair left = checkNode(node.left);
	Pair right = checkNode(node.right);

	int across = 1 + left.depth + right.depth;
	int longestPath = Math.max(across, 
		Math.max(left.longestPath, right.longestPath));

	int depth = 1 + Math.max(left.depth, right.depth);
	return new Pair(depth, longestPath);
}

class Pair {
	int depth;
	int longestPath;
	Pair(int d, int l) {
		depth = d;
		longestPath = l;
	}
}