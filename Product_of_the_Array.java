// O(2 ^ N)
public List<Integer> products(int[] input) {
	Set<Integer> set = new HashSet<>();
	Arrays.sort(input);
	helper(set, input, 1, 0, true);
	return new ArrayList<>(set);
}

public void helper(Set<Integer> set, int[] input, int curPro, int pos, boolean first) {
	if (!first) set.add(curPro);
	first = false;

	for (int i = pos; i < input.length; i++) {
		if (i != pos && input[i] == input[i-1]) {
			continue;
		}

		if (input[i] == 0) {
			set.add(0);
			continue;
		}

		helper(set, input, curPro * input[i], i+1, first);
	}
}