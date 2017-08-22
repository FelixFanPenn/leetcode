class Solution {
    public int strStr(String haystack, String needle){
        if (haystack == null || needle == null)
            return -1;
    //generate next array, need O(n) time
        int i = -1, j = 0, m = haystack.length(), n = needle.length();
        if (n == 0) return 0;
        int[] next = kmp(needle);

    //check through the haystack using next, need O(m) time
        i = 0; j = 0;
        while (i < m && j < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = next[j-1];
                } else {
                    i++;
                }
            }
        }
        if (j == n)
            return i - j;
        return -1;
    }
    
    private int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }
}