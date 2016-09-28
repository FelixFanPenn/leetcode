/*
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int digits = 1, tmp = x;
        
        while(tmp > 9){
            digits = 10 * digits;
            tmp /= 10;
        }
        
        while(x > 0){
            int x1 = x/digits;
            int x2 = x%10;
            if (x1 != x2) return false;
            x = (x%digits)/10;
            digits /= 100;
        }
        return true;
    }
}

*/
public class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
        	rev = rev*10 + x%10;
    	    x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
