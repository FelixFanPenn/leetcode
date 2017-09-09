public class WindowSum {
    public static int[] solution(int[] arr, int k) {
        int len = arr.length;
        int[] res = new int[len - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int left = 0;
        res[left++] = sum;
        for (int i = k; i < len; i++) {
            sum += arr[i] - arr[left-1];
            res[left++] = sum;
        }
        
        return res;
    }
}
