
class DoublyLinkedList {
	DoublyLinkedList pre;
	DoublyLinkedList next;
	int val;
	public DoublyLinkedList(int value) {
		val = value;
	}
}

class BT2DLL {
	public DoublyLinkedList BT2DLL(TreeNode root) {
		if (root == null) return null;
		Stack<TreeNode> stack = new Stack<>();
		DoublyLinkedList fakeHead = new DoublyLinkedList(-1);
		DoublyLinkedList prev = fakeHead;
		toLeft(stack, root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			DoublyLinkedList tmp = new DoublyLinkedList(node.val);
			tmp.pre = prev;
			prev.next = tmp;
			prev = tmp;
			if (node.right != null) {
				toLeft(stack, node.right);
			}
		}

		DoublyLinkedList head = fakeHead.next;
		head.pre = prev;
		prev.next = head;
		return head;
	}

	public void toLeft(Stack<TreeNode> stack, TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}