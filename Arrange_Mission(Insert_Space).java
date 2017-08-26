public String arrange(String input, int k) {
	if (input.length() < 2) return input;
	StringBuilder sb = new StringBuilder();
	HashMap<Character, Integer> map = new HashMap<>();
	int time = 0;
	char[] chars = input.toCharArray();

	for (int i = 0; i < chars.length; i++) {
		time++;
		if (!map.containsKey(chars[i]) || time - map.get(chars[i]) > k) {
			sb.append(chars[i]);
			map.put(chars[i], time);
		} else {
			int gap = k - (time - map.get(chars[i]));
			while (gap > 0) {
				sb.append('_');
				gap--;
			}
			time = k + map.get(chars[i]) + 1;
			map.put(chars[i], time);
			sb.append(chars[i]);
		}
	}
	return sb.toString();
}