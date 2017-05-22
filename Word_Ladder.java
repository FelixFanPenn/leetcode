public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        set.addAll(wordList);
        visited.add(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String str = queue.poll();
                for (int j = 0; j < str.length(); j++){
                    char[] c = str.toCharArray();
                    char ch = c[j];
                    for (char k = 'a'; k <= 'z'; k++){
                        c[j] = k;
                        String string = new String(c);
                        if (set.contains(string)){
            
                            if (string.equals(endWord)){
                                return level+1;
                            } else {
                                if (!visited.contains(string)){
                                    queue.offer(string);
                                    visited.add(string);
                                }
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
