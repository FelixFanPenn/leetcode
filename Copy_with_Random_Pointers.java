/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode itr = newHead;
        
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        
        
        while (head != null){
            RandomListNode node;
            int v = head.label;
            if (map.containsKey(v)){
                node = map.get(v);
            } else {
                node = new RandomListNode(head.label);
                map.put(v, node);
            }
            
            if (head.random != null){
                RandomListNode rand;
                int l = head.random.label;
                if (map.containsKey(l)){
                    node.random = map.get(l);
                } else {
                    node.random = new RandomListNode(l);
                    map.put(l, node.random);
                }
            }
            
            itr.next = node;
            itr = itr.next;
            head = head.next;
            
        }
        
        
        return newHead.next;
    }
}