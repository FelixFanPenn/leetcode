public int strStr(List<List<Character>> haystack, String needle) {
	int total = 0;
	for (int row = 0; row < haystack.size(); row++) {
		for (int col = 0; col < haystack.get(0).size(); col++) {
			int k = 0, posRow = row, posCol = col;
			while (posRow < haystack.size() && posCol < haystack.get(posRow).size() 
					&& k < needle.length() && haystack.get(posRow).get(posCol) == needle.charAt(k)) {
				k++;
				posCol++;
				if (posCol == haystack.get(posRow).size()) {
					posCol = 0;
					posRow++;
				}
			}
			if (k == needle.length()) {
				return total + col - 1;
			}
		}
		total += haystack.get(row).size();
	}
	return -1;
}