public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int maxlen = findMaxLen(wordDict);
        if (wordDict == null || maxlen == 0) return false;
        
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        
        for (int i = 1; i <= s.length(); i++){
            res[i] = false;
            for (int j = 1; j <= i && j <= maxlen; j++){ // j is last word length
                String str = s.substring(i-j, i);
                if (wordDict.contains(str) && res[i-j] == true){  // if last word is in dict and segment is valid
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
    
    private int findMaxLen(Set<String> wordDict){
        int maxlen = 0;
        for (String str: wordDict){
            maxlen = Math.max(maxlen, str.length());
        }
        return maxlen;
    }
}
