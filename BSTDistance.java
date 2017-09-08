public class BSTDistance {

    private BTreeNode root;
    public void CreateBST(int[] values){
        for (int i = 0; i < values.length; i++){
            add(values[i]);
        }
    }
    
    public void add(int item){
        if (root == null) root = new BTreeNode(item);
        else add(root,item);
    }
    
    public void add(BTreeNode node,int item){
        if (item < node.val) {
            if (node.left == null) node.left = new BTreeNode(item);
            else add(node.left, item);
        } else if (item > node.val) {
            if (node.right == null) node.right = new BTreeNode(item);
            else add(node.right, item);
        }
    }
    
    public  int bstDistance(int[] values, int node1, int node2){
            CreateBST(values);
            int l1 = distToRoot(root, node1);
            int l2 = distToRoot(root, node2);
            if (l1 == -1 && l2 == -1) return -1;
            int lcaVal = findLCA(root, node1, node2).val;
            int lcaDistance = distToRoot(root, lcaVal);
 
            return (l1 + l2) - 2 * lcaDistance >= 0 ? (l1 + l2) - 2 * lcaDistance : -1;
    }
    
    public int distToRoot(BTreeNode root, int n) {
            return distToRootHelper(root, n) - 1;
    }
    
    public int distToRootHelper(BTreeNode root, int n) {
            if (root != null) {
                if (root.val == n) return 1;
                int x1 = distToRootHelper(root.left, n);
                if (x1 > 0) return x1 + 1;
                int x2 = distToRootHelper(root.right, n);
                if (x2 > 0) return x2 + 1;
                return 0;
            }
            return 0;
    }
    
    public BTreeNode findLCA(BTreeNode root, int node1, int node2) {
            if (root != null) {
                if (root.val == node1 || root.val == node2) return root;
                
                BTreeNode left = findLCA(root.left, node1, node2);
                BTreeNode right = findLCA(root.right, node1, node2);

                if (left != null && right != null) return root;
                if (left != null) return left;
                if (right != null) return right;
            }
            return null;
    }
    
    class BTreeNode {
        int val;
        BTreeNode left, right;  
        public BTreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BSTDistance test = new BSTDistance();
        int values[] = {5, 3, 4, 7, 0};
        int res = test.bstDistance(values, 0, 4);
        System.out.println(res);
    }
}