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



	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)    return "N";
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("N,");   
            }
            else{
                sb.append(cur.val).append(',');
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("\\,");
        if (nodes.length == 1) return null;
    
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;           // starting from the second node if root is not null
    
        while (i < nodes.length) {
            TreeNode node = queue.poll();
    
            String left = nodes[i++], right = nodes[i++];
            if (!left.equals("N")) {
                TreeNode lChild = new TreeNode(Integer.parseInt(left));
                node.left = lChild;
                queue.offer(lChild);
            }
            if (!right.equals("N")) {
                TreeNode rChild = new TreeNode(Integer.parseInt(right));
                node.right = rChild;
                queue.offer(rChild);
            }
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
