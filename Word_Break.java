public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        int maxLen = getMaxLen(wordDict);
        int len = s.length();
        
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        
        for (int i = 1; i < res.length; i++){
            for (int j = i-1; j >= i - maxLen && j >= 0; j--){
                String tmp = s.substring(j, i);
                if (set.contains(tmp) && res[j]) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
    
    public int getMaxLen(List<String> w){
        int max = 0;
        for (String s : w){
            max = Math.max(s.length(), max);
        }
        return max;
    }
}