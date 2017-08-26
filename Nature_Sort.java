class CompareString implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		int index1 = 0, index2 = 0;
		while (index1 < s1.length() && index2 < s2.length()) {
			char c1 = s1.charAt(index1);
			char c2 = s2.charAt(index2);
			if (c1 == c2 && !Character.isDigit(c1)) {	// both are chars
				index2++; index1++;
			} else if (Character.isDigit(c1) && Character.isDigit(c2)) { // both are numbers
				int n1 = 0, n2 = 0;
				while (index1 < s1.length() && Character.isDigit(s1.charAt(index1))) {
					n1 = n1 * 10 + s1.charAt(index1) - '0';
					index1++;
				}

				while (index2 < s2.length() && Character.isDigit(s2.charAt(index2))) {
					n2 = n2 * 10 + s2.charAt(index2) - '0';
					index2++;
				}

				if (n1 > n2) {
					return 1;
				} else if (n1 < n2) {
					return -1;
				}
			} else { 		// not equal or one is number
				if (Character.isDigit(c2)) {
					return 1;
				} else if (Character.isDigit(c1)) {
					return -1;
				}

				if (c1 > c2) {
					return 1;
				}
				return -1;
			}
		}
		if (index1 == s1.length() && index2 == s2.length()) {
			return 0;
		} else if (index1 < s1.length()) {
			return 1;
		} else {
			return -1;
		}
	}
}