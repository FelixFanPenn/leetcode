// time O(K) K is the input target

public List<List<Integer>> find(int target) {
	List<List<Integer>> res = new ArrayList<>();
	helper(res, new ArrayList<>(), 1, target, 0);
	return res;
}

public helper(List<List<Integer>> res, List<Integer> path, int pos, int target, int sum) {
	if (sum == target) {
		res.add(new ArrayList<>(path));
		return;
	}

	for (int i = pos; i <= target; i++) {
		if (sum + i > target) {
			break;
		}
		sum += i;
		path.add(i);
		helper(res, path, i, target, sum);
		sum -= i;
		path.remove(path.size()-1);
	}
}