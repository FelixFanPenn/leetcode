class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        helper(graph, 0, res, tmp);
        return res;
    }
    
    private void helper(int[][] graph, int idx, List<List<Integer>> res, List<Integer> tmp) {
        if (idx == graph.length-1) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int g : graph[idx]) {
            tmp.add(g);
            helper(graph, g, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}