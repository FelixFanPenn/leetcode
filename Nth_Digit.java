public class Solution {
    public int findNthDigit(int num) {
        long start = 1, len = 1, cnt = 9;
        
        while (num > len * cnt) {
            num -= len * cnt;
            len++;
            start *= 10;
            cnt *= 10;
        }
        start += (num-1)/len;
        
        return ("" + start).charAt((int)((num-1) % len)) - '0';
    }
}