public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] res = new int[len1+1][len2+1];   //res[i][j] means edit distance of word1.substring(0, i) and word2.substring(0, j)
        res[0][0] = 0;
        
        for (int i = 1; i <= len1; i++){
            res[i][0] = i;
        }
        
        for (int j = 1; j <= len2; j++){
            res[0][j] = j;
        }
        
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    res[i][j] = Math.min(Math.min(res[i-1][j] + 1, res[i][j-1] + 1), res[i-1][j-1]);
                } else {
                    res[i][j] = Math.min(Math.min(res[i-1][j] + 1, res[i][j-1] + 1), res[i-1][j-1] + 1);
                }
            }
        }
        return res[len1][len2];
    }
}
