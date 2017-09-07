package BSTDistance;

class BTreeNode {
	int val;
	BTreeNode left, right;	
	public BTreeNode(BTreeNode left, int val, BTreeNode right) {
		this.left = left;
		this.val = val;
		this.right = right;
	}
}

public class BSTDistance {

    private BTreeNode root;
    public void CreateBST(int[] values,int n){
    	for (int i = 0; i < n; i++){
          	add(values[i]);
        }
    }
    
    public void add(int item){
        if(root == null){
            root = new BTreeNode(null,item,null);
        }else{
            add(root,item);
        }
    }
    
    public void add(BTreeNode node,int item){
        if (item < node.val) {
            if (node.left == null) {
                node.left = new BTreeNode(null, item, null);
            } else {
                add(node.left, item);
            }
        } else if (item > node.val) {
            if (node.right == null) {
                node.right = new BTreeNode(null, item, null);
            } else {
                add(node.right, item);
            }
        }
    }
    
    public  int bstDistance(int[] values, int n, int node1, int node2){
            int l1 = Pathlength(root,node1);
            int l2 = Pathlength(root,node2);
            if (l1 != 0 && l2 != 0) return -1;
            int lcaVal = findLCA(root, node1, node2).val;
            int lcaDistance = Pathlength(root, lcaVal);
 
            return (l1 + l2) - 2 * lcaDistance >= 0 ? (l1 + l2) - 2 * lcaDistance : -1;
    }
    
    public int Pathlength(BTreeNode root, int n) {
            return PathlengthHelp(root,n)-1;
    }
    
    public int PathlengthHelp(BTreeNode root, int n) {
            if (root != null) {
               // int x = 0;
                if (root.val == n) return 1;
                int x1 = PathlengthHelp(root.left, n);
                if (x1 > 0) return x1 + 1;
                int x2 = PathlengthHelp(root.right, n);
                if (x2 > 0) return x2 + 1;
                //if ((root.val == n) || (x = PathlengthHelp(root.left, n)) > 0
                  //                  || (x = PathlengthHelp(root.right, n)) > 0) {
                  //  return x+1 ;
                //}
                return 0;
            }
            return 0;
    }
    
    public BTreeNode findLCA(BTreeNode root, int node1, int node2) {
            if (root != null) {
            	if (root.val == node1 || root.val == node2) {
                    return root;
                }
                BTreeNode left = findLCA(root.left, node1, node2);
                BTreeNode right = findLCA(root.right, node1, node2);

                if (left != null && right != null) {
                    return root;
                }
                if (left != null) return left;
                if (right != null) return right;
            }
            return null;
    }

    public static void main(String[] args) {
    	BSTDistance test = new BSTDistance();
        int values[] = {1, 4, 2, 5, 7, 3};
        test.CreateBST(values, 6);
        int res = test.bstDistance(values, 6, 8, 9);
        System.out.println(res);
    }
}