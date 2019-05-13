// Java program to check if two binary tree are cousins 
class Node 
{ 
    int data; 
    Node left, right; 
  
    Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
class BinaryTree 
{ 
    Node root; 
  
    // Recursive function to check if two Nodes are 
    // siblings 
    boolean isSibling(Node node, Node a, Node b) 
    { 
        // Base case 
        if (node == null) 
            return false; 
  
        return ((node.left == a && node.right == b) || 
                (node.left == b && node.right == a) || 
                isSibling(node.left, a, b) || 
                isSibling(node.right, a, b)); 
    } 
  
    // Recursive function to find level of Node 'ptr' in 
    // a binary tree 
    int level(Node node, Node ptr, int lev) 
    { 
        // base cases 
        if (node == null) 
            return 0; 
  
        if (node == ptr) 
            return lev; 
  
        // Return level if Node is present in left subtree 
        int l = level(node.left, ptr, lev + 1); 
        if (l != 0) 
            return l; 
  
        // Else search in right subtree 
        return level(node.right, ptr, lev + 1); 
    } 
  
    // Returns 1 if a and b are cousins, otherwise 0 
    boolean isCousin(Node node, Node a, Node b) 
    { 
        // 1. The two Nodes should be on the same level 
        //       in the binary tree. 
        // 2. The two Nodes should not be siblings (means 
        //    that they should not have the same parent 
        //    Node). 
        return ((level(node, a, 1) == level(node, b, 1)) && 
                (!isSibling(node, a, b))); 
    } 
  
    //Driver program to test above functions 
    public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.right = new Node(15); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
  
        Node Node1, Node2; 
        Node1 = tree.root.left.left; 
        Node2 = tree.root.right.right; 
        if (tree.isCousin(tree.root, Node1, Node2)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
} 




import java.io.*; 
import java.util.*; 
import java.lang.*; 
// A Binary Tree Node 
class Node  
{ 
    int data; 
    Node left, right; 
    Node(int key) 
    { 
        data = key; 
        left = right = null; 
    } 
} 
  
class GFG {
static void printCousins(Node root,  
                         Node node_to_find) 
{
    if (root == node_to_find){ 
        return; 
    } 
    Queue<Node> q = new LinkedList<Node>(); 
    boolean found = false; 
    int size_ = 0; 
    Node p = null; 
    q.add(root);
    while (q.isEmpty() == false &&  
                 found == false)  
    { 
        size_ = q.size(); 
        while (size_ -- > 0)  
        { 
            p = q.pop(); 
            if ((p.left == node_to_find ||  
                 p.right == node_to_find))  
            { 
                found = true; 
            } 
            else
            { 
                if (p.left != null) 
                    q.add(p.left); 
                if (p.right!= null) 
                    q.add(p.right); 
            } 
        } 
    } 

    if (found == true)  
    { 
        System.out.print("Cousin Nodes : "); 
        size_ = q.size(); 
        if (size_ == 0) 
            System.out.print("None"); 
          
        for (int i = 0; i < size_; i++)  
        { 
            p = q.peek(); 
            q.poll(); 
              
            System.out.print(p.data + " "); 
        } 
    } 
    else
    { 
        System.out.print("Node not found"); 
    } 
      
    System.out.println(""); 
    return; 
} 
  
// Driver code 
public static void main(String[] args) 
{ 
    Node root = new Node(1); 
    root.left = new Node(2); 
    root.right = new Node(3); 
    root.left.left = new Node(4); 
    root.left.right = new Node(5); 
    root.left.right.right = new Node(15); 
    root.right.left = new Node(6); 
    root.right.right = new Node(7); 
    root.right.left.right = new Node(8); 
  
    Node x = new Node(43); 
  
    printCousins(root, x); 
    printCousins(root, root); 
    printCousins(root, root.right); 
    printCousins(root, root.left); 
    printCousins(root, root.left.right); 
} 
} 
