public class Longest_Arithmetic {
	public static int getLAS(int[] A){
	    if (A.length < 3) return 0;
	    
	    int res = 0, diff = Integer.MIN_VALUE;
	    int count = 0, start = 0;
	    for (int i = 1; i < A.length; i++){
	        int curDiff = A[i] - A[i - 1];
	        if (diff == curDiff){
	            count += i - start - 1 > 0 ? i - start - 1 : 0;
	        } else {
	            start = i - 1;
	            diff = curDiff;
	            res += count;
	            count = 0;
	        }
	    }
	    res += count;
	    return res;
	}
}
