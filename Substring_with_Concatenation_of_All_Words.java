public class Solution {
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word
    
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
    
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }
    
    /*
    public List<Integer> findSubstring(String s, String[] words) {
	int N = s.length();
	List<Integer> indexes = new ArrayList<Integer>(s.length());
	if (words.length == 0) {
		return indexes;
	}
	int M = words[0].length();
	if (N < M * words.length) {
		return indexes;
	}
	int last = N - M + 1;
	
	//map each string in words array to some index and compute target counters
	Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
	int [][] table = new int[2][words.length];
	int failures = 0, index = 0;
	for (int i = 0; i < words.length; ++i) {
		Integer mapped = mapping.get(words[i]);
		if (mapped == null) {
			++failures;
			mapping.put(words[i], index);
			mapped = index++;
		}
		++table[0][mapped];
	}
	
	//find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
	int [] smapping = new int[last];
	for (int i = 0; i < last; ++i) {
		String section = s.substring(i, i + M);
		Integer mapped = mapping.get(section);
		if (mapped == null) {
			smapping[i] = -1;
		} else {
			smapping[i] = mapped;
		}
	}
	
	//fix the number of linear scans
	for (int i = 0; i < M; ++i) {
		//reset scan variables
		int currentFailures = failures; //number of current mismatches
		int left = i, right = i;
		Arrays.fill(table[1], 0);
		//here, simple solve the minimum-window-substring problem
		while (right < last) {
			while (currentFailures > 0 && right < last) {
				int target = smapping[right];
				if (target != -1 && ++table[1][target] == table[0][target]) {
					--currentFailures;
				}
				right += M;
			}
			while (currentFailures == 0 && left < right) {
				int target = smapping[left];
				if (target != -1 && --table[1][target] == table[0][target] - 1) {
					int length = right - left;
					//instead of checking every window, we know exactly the length we want
					if ((length / M) ==  words.length) {
						indexes.add(left);
					}
					++currentFailures;
				}
				left += M;
			}
		}
		
	}
	return indexes;
    }
    */
}