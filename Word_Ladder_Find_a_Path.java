public List<String> findLadder (String start, String end, Set<String> set) {
	Queue<String> q = new LinkedList<>();
	HashMap<String, String> map = new HashMap<>();
	List<String> res = new ArrayList<>();

	q.offer(start);
	map.put(start, "");
	boolean found = false;

	while (!q.isEmpty() && !found) {
		String s = q.poll();

		for (int i = 0; i < s.length(); i++) {
			for (char k = 'a'; k <= 'z'; k++) {
				if (k == s.charAt(i)) continue;
				String tmp = s.substring(0, i) + k + s.substring(i+1);
				if (tmp.equals(end)) {
					map.put(end, tmp);
					found = true;
					break;
				}
				if (set.contains(tmp) && !map.containsKey(tmp)) {
					map.put(tmp, s);
					q.offer(tmp);
				}
			}
		}
	}

	if (!map.containsKey(end)) return res;
	while (!map.get(end).equals("")) {
		res.add(0, end);
		end = map.get(end);
	}
	res.add(0, start);
	return res;
}