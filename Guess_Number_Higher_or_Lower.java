/*
   ram num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(true){
            int mid = left + (right - left)/2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res == 1){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}
