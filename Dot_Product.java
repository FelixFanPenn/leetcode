/*
	two vectors are very sparse so the vectors are given like this:
	A = {{1, 8}, {5, 3}} ==>> at index 1, there is 8, at index 5, there is 3
	rest indices are all zero
*/

// O(max(len(a), len(b)))

public int dotProduct(int[][] A, int[][] B) {
	int indexa = 0, indexb = 0;
	int product = 0;

	while (indexa < A.length && indexb < B.length) {
		if (A[indexa][0] == B[indexb][0]) {
			product += A[indexa][1] * B[indexb][1];
			indexb++;
			indexa++;
		} else if (A[indexa][0] > B[indexb][0]) {
			indexb++;
		} else {
			indexa++;
		}
	}
	return product;
}

// if len of a >>> len of b
// Binary search! O(N log M) M is len of A, N is len of B

public int dotProduct(int[][] A, int[][] B) {
	int sum = 0;
	for (int[] pair : A) {
		int indexa = pair[0];
		int indexb = binarySearch(B, indexa);
		if (indexb != -1) {
			sum += A[indexa][1] * B[indexb][1];
		}
	}
	return sum;
}

public int binarySearch(int[][], int index) {
	int low = 0, high = B.length - 1;
	while (low + 1 < high) {
		int mid = (high - low) / 2 + low;
		if (B[mid][0] == index) {
			return mid;
		} else if (B[mid][0] > index) {
			right = mid;
		} else {
			left = mid;
		}
	}
	if (B[left][0] == index) return left;
	if (B[right][0] == index) return right;
	return -1;
}