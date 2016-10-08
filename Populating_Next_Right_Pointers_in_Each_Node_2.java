/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode head = null, pre = null;//pre ---> the leading node on the next level
                     //head of the next level
        while(cur != null){
            while (cur != null){
                if(cur.left != null){
                    if (pre != null){
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                } 
                
                if (cur.right != null){
                    if (pre != null){
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;//move to next node
            }
            
            cur = head;  // move to next level
            pre = null;
            head = null;
        }
    }
}
