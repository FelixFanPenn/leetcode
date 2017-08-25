// time O(n)
// space O(n)


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

public TreeNode findLCAIterative(TreeNode root){
	if (root == null) return null;
	Map<TreeNode, TreeNode> childToParent = new HashMap<>();
	TreeNode l = null, r = null;
	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);

	while (!q.isEmpty()) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			TreeNode node = q.poll();
			if (i == 0) l = node;
			if (i == size-1) r = node;
			if (node.left != null) {
				q.offer(node.left);
				childToParent.put(node.left, node);
			}
			if (node.right != null) {
				q.offer(node.right);
				childToParent.put(node.right, node);
			}
		}
	}

	while (l != r) {
		l = childToParent.get(l);
		r = childToParent.get(r);
	}
	return l;
}