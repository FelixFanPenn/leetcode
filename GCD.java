public class GCD {
	public static int gcd(int[] arr) {
		int g = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (g == 0 || arr[i] == 0) return 0;
			g = helper(g, arr[i]);
		}
		
		return g;
	}
	
	public static int helper(int a, int b) {
		if (b == 0) return a;
		//if (b > a) return helper(b, a);
		return helper(b, a % b);
	}
}
