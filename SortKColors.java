// O(N * N)
public void sortKColor(int[] colors, int k) {
	int left = 0, right = colors.length-1;

	while (k > 0) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = left; i < right; i++) {
			min = Math.min(min, colors[i]);
			max = Math.max(max, colors[i]);
		}
		int index = left, minIndex = left, maxIndex = right;

		while (minIndex < maxIndex && index <= maxIndex) {
			if (colors[index] == min) {
				colors[index] = colors[minIndex];
				colors[minIndex] = min;
				minIndex++;
				index++;
			} else if (colors[index] == max) {
				colors[index] = colors[maxIndex];
				colors[maxIndex] = max;
				maxIndex--;
			} else {
				index++;
			}
		}

		left = minIndex;
		right = maxIndex;
		k -= 2;
	}
}

// QUICK SORT O(NLOGN)

// BUCKET SORT O(N)

// COUNTING SORT O(K) EXTRA SPACE

// BUCKET SORT O(N) NO EXTRA SPACE
// http://wdxtub.com/interview/14520606003957.html
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null) {
            return;
        }

        int len = colors.length;
        for (int i = 0; i < len; i++) {
            // Means need to deal with A[i]
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {
                    // 1. There is a number in the bucket,
                    // Store the number in the bucket in position i;
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                } else if (colors[num - 1] <= 0) {
                    // 2. Bucket is using or the bucket is empty.
                    colors[num - 1]--;
                    // delete the A[i];
                    colors[i] = 0;
                }
            }
        }

        int index = len - 1;
        for (int i = k - 1; i >= 0; i--) {
            int cnt = -colors[i];

            // Empty number.
            if (cnt == 0) {
                continue;
            }

            while (cnt > 0) {
                colors[index--] = i + 1;
                cnt--;
            }
        }
    }
}