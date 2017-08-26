public List<Integer> flatten(List<NestedInteger> nestedList) {
	List<Integer> res = new ArrayList<>();
	if (nestedList == null) return res;

	Stack<NestedInteger> stack = new Stack<>();
	for (int i = nestedList.size() - 1; i >= 0; i--) {
		stack.push(nestedList.get(i));
	}

	while (!stack.isEmpty()) {
		NestedInteger x = stack.pop();
		if (x.isInteger()) {
			res.add(x.getInteger());
			continue;
		}
		for (int i = x.getList().size() - 1; i >= 0; i--) {
			stack.push(x.getList().get(i));
		}
	}
	return res;
}