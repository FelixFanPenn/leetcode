public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lens = s.length(), lent = t.length();
        int len = lens > lent ? lent : lens;
        for (int i = 0; i < len; i++){
            if (s.charAt(i) != t.charAt(i)){
                if (lens == lent){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if (lens > lent){
                    return s.substring(i+1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return Math.abs(lens-lent) == 1;
    }
}

/*
find the first different character
if two strings have same length, the rest of them should be identical
if one is longer, the rest of the longer one excluding this index should be identical with the shorter one
vice versa

if all chars are identical, test if one string is longer by one char
*/
