public String wordBreak(String input, Set<String> set) {
	List<String> path = new ArrayList<>();
	helper(path, input, set, 0);
	StringBuilder sb = new StringBuilder();
	for (String word : path) {
		sb.append(word + " ");
	}
	sb.deleteCharAt(sb.length()-1);
	return sb.toString();
}

public boolean helper(List<String> path, String input, Set<String> set, int pos) {
	if (input.length() == pos) return true;

	for (int i = pos; i < input.length(); i++) {
		String s = input.substring(pos, i+1);
		if (set.contains(s)) {
			path.add(s);
			if (helper(path, input, set, i+1)) return true;
			path.remove(path.size()-1);
		}
	}
	return false;
}