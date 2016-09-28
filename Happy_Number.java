public class Solution {
    public boolean isHappy(int n) {
        int num = 0;
        while(n != 1 && n != 4){   // if n is 4 ---> impossible
            
            while(n > 0){
                num += (n%10) * (n%10);
                n /= 10;
            }
            n = num; num = 0;
        }
        return n == 1;
    }
}
