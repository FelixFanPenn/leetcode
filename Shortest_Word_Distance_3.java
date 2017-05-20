public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++){
                if (words[i].equals(word1)){
                    if (index1 == Integer.MAX_VALUE){
                        index1 = i;
                    } else if (index2 == Integer.MAX_VALUE){
                        index2 = i;
                        dist = Math.min(dist, Math.abs(index2 - index1));
                    } else {
                        index1 = index2;
                        index2 = i;
                        dist = Math.min(dist, Math.abs(index2 - index1));
                    }
                }
            }
        } else {
            for (int i = 0; i < words.length; i++){
                if (words[i].equals(word1)){
                    index1 = i;
                    dist = Math.min(dist, Math.abs(index2 - index1));
                } else if (words[i].equals(word2)){
                    index2 = i;
                    dist = Math.min(dist, Math.abs(index2 - index1));
                }
            }
        }
        return dist;
    }
}