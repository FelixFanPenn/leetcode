/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        push(s, root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            q.offer(node);
            push(s, node.right);
        }
        Node head = q.peek(), pre = head;
        while (!q.isEmpty()) {
            Node node = q.poll();
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
    
    private void push(Stack<Node> s, Node node) {
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }
}