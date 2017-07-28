/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> s1 = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
            } else if (s.charAt(i) == ')') {
                i++;
                s1.pop();
            } else {
                int j = i+1;
                while (j < s.length() && s.charAt(j) != '(' && s.charAt(j) != ')') {
                    j++;
                }
                int num = Integer.valueOf(s.substring(i, j));
                TreeNode node = new TreeNode(num);
                if (s1.isEmpty()) {
                    s1.push(node);
                } else {
                    if (s1.peek().left == null) {
                        s1.peek().left = node;
                    } else {
                        s1.peek().right = node;
                    }
                    s1.push(node);
                }
                i = j;
            }
        }
        
        return s1.isEmpty() ? null : s1.pop();
    }
}