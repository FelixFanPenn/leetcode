import java.util.Arrays;

public class DayChange {
    public static int[] dayChange(int[] input, int day) {
        if (input == null || day <= 0 || input.length == 0) return input;
        int len = input.length;
        
        int[] res = new int[len+2];
        for (int i = 0; i < len; i++) {
            res[i+1] = input[i];
        }
        
        for (int i = 0; i < day; i++) {
            int pre = res[0];
            for (int j = 1; j <= len; j++) {
                int tmp = res[j];
                res[j] = pre ^ res[j+1];
                pre = tmp;
            }
        }
        return Arrays.copyOfRange(res, 1, len+1);
    }
}
