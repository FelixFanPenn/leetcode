public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                int j = i - 1;
                while(j >= 0){
                    if (words[j].equals(word2)){
                        distance = Math.min(distance, i - j);
                        break;
                    }
                    j--;
                }
                j = i + 1;
                while(j < words.length){
                    if (words[j].equals(word2)){
                        distance = Math.min(distance, j - i);
                        break;
                    }
                    j++;
                }
            }
        }
        return distance;
    }
}
