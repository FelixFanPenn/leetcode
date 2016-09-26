/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String splitter = ",";
    private String np = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        help(root, sb);
        return sb.toString();
    }
    
    private void help(TreeNode root, StringBuilder sb){
        if (root == null) {
            sb.append(np).append(splitter);
        } else {
            sb.append(Integer.toString(root.val)).append(splitter);
            help(root.left, sb);
            help(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> str = new LinkedList<>();     // both queue and deque work fine
        str.addAll(Arrays.asList(data.split(splitter)));
        return helper(str);
    }
    
    private TreeNode helper(Queue<String> str){
        String s = str.remove();
        if (s.equals(np)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));   // both Integer.valueOf(s) and Integer.parseInt(s) work fine
        root.left = helper(str);
        root.right = helper(str);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
