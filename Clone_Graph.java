/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return cloneHelper(node, map);
    }
    
    private UndirectedGraphNode cloneHelper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        if (node == null){
            return null;
        }
        
        if (map.containsKey(node.label)){
            return map.get(node.label);
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors){
            newNode.neighbors.add(cloneHelper(neighbor, map));
        }
        
        return newNode;
    }
}
