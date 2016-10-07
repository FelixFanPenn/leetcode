public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;
        
        int lenN = needle.length(), lenH = haystack.length();
        if (lenN > lenH) return -1;
        
        for (int i = 0; i < lenH-lenN+1; i++){
            boolean flag = true;
            for (int j = 0; j < lenN; j++){
                if (needle.charAt(j) != haystack.charAt(i+j)){
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}
