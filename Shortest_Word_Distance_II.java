public class WordDistance {
    
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i])){
                map.get(words[i]).add(i);
            } else {
                map.put(words[i], new ArrayList<>());
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> one = map.get(word1);
        ArrayList<Integer> two = map.get(word2);
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < one.size(); i++){
            for (int j = 0; j < two.size(); j++){
                if (distance > Math.abs(one.get(i) - two.get(j))){
                    distance = Math.abs(one.get(i) - two.get(j));
                }
            }
        }
        return distance;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
