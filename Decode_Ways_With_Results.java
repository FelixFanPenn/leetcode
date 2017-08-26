public List<String> decode(String num) {
	List<String> res = new ArrayList<>();
	helper(res, 0, num, "");
	return res;
}

public void helper(List<String> res, int pos, String num, String way) {
	if (pos == nums.length()) {
		res.add(way);
		return;
	}

	String digits = num.substring(pos, pos+1);
	int n = Integer.parseInt(digits);
	if (n == 0) {
		return;
	} else {
		helper(res, pos+1, num, way + (char)(n + 'A' - 1));
		if (pos < num.length() - 1) {
			String digits2 = num.substring(pos, pos+2);
			int n2 = Integer.parseInt(digits2);
			if (n2 <= 26) {
				helper(res, pos+2, num, way + (char)(n2 + 'A' - 1));
			}
		}
	}
}