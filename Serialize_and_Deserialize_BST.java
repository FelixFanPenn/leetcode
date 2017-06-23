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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();

        sHelper(sb, root);
        
        return sb.toString();
    }
    
    public void sHelper(StringBuilder sb, TreeNode root){
        if (root == null){
            sb.append("null,");
        } else {
            sb.append(root.val + ",");
            sHelper(sb, root.left);
            sHelper(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        
        return dhelper(queue);
        
    }
    
    public TreeNode dhelper(Queue<String> queue){
        String str = queue.remove();
        if (str.equals("null")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = dhelper(queue);
        root.right = dhelper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));