class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        if (pid.size() == 0 || ppid.size() == 0) return res;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) {
                map.put(ppid.get(i), new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        res.add(kill);
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);
        while (!q.isEmpty()) {
            int key = q.poll();
            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                res.addAll(list);
                q.addAll(list);
            }
        }
        return res;
    }
}