public void sample(int[][] input, int k) {
	Point[] points = new Point[k];
	Random rand = new Random();
	int width = input[0].length;
	int height = input.length;
	int index = 0;

	while (index < width * height && index < k) {
		points[index] = new Point(index / width, index % width);
		input[index / width][index % width] = 1;
		index++;
	}
	if (index < k) return;

	index = k;
	while (index < width * height) {
		int newIndex = rand.nextInt(index);
		if (newIndex < k) {
			input[points[newIndex].x][points[newIndex].y] = 0;
			int row = index / width;
			int col = index % width;
			input[row][col] = 1;
			points[newIndex] = new Point(row, col);
		}
		index++;
	}
}

/*

for first k points, initialize them as 1 (picking them)
for the k+1 to end points:
create a random number j which range from 0 to index
if this j < k, we choose this point replacing points[j]

Prove:
for points index after k, if we choose it and we don't replace it afterwards:
(k / index) (index / index + 1) (index + 1 / index + 2) ... (n - 1 / n) = k / n

for points index before k, if we choose them eventually, no replacement:
(k / k + 1) (k + 1 / k + 2) ... (n - 1 / n) = k / n

*/