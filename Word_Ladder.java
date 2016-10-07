/*
public class Solution {   // beat 49%  using a set
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> visited = new HashSet<String>();
        wordList.add(endWord);
        visited.add(beginWord);
        int distance = 1;
        
        while(!visited.isEmpty()){
            Set<String> bfs = new HashSet<String>();
            for (String str: visited){

                for (int i = 0; i < str.length(); i++){
                    char[] arr = str.toCharArray();
                    for (char c ='a'; c <= 'z'; c++){
                        arr[i] = c;
                        String tmp = new String(arr);
                        if (wordList.contains(tmp)){
                            bfs.add(tmp);
                            wordList.remove(tmp);
                        }
                        if (!wordList.contains(endWord)){
                            return distance+1;
                        }
                    }
                }
            }
            if (bfs.isEmpty()){
                break;
            }
            distance++;
            visited = bfs;
        }
        return 0;
    }
}

*/

/*
public class Solution {   // beat 81%  using a queue
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        wordList.add(endWord);
        wordList.remove(beginWord);
        queue.offer(beginWord);
        int level = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String tmp = queue.poll();
                if (tmp.equals(endWord)){
                    return level;
                }
                List<String> neighbors = findNeighbors(wordList, tmp);
                for (String str: neighbors){
                    queue.offer(str);
                }
            }
            level++;
        }
        return 0;
    }
    
    private List<String> findNeighbors(Set<String> wordList, String str){
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < str.length(); i++){
            char[] arr = str.toCharArray();
            for (char c ='a'; c <= 'z'; c++){
                arr[i] = c;
                String tmp = new String(arr);
                if (wordList.remove(tmp)){
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    
}

*/

public class Solution {   // beat 86%  using two sets
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
	    Set<String> visited = new HashSet<String>();
	    begin.add(beginWord); end.add(endWord);
        int len = 1;
	    
	    while(!begin.isEmpty() && !end.isEmpty()){
	        if (begin.size() > end.size()){
	            Set<String> tmp = begin;
	            begin = end;
	            end = tmp;
	        }
	        
	        Set<String> tmp = new HashSet<String>();
	        for (String str: begin){
	            char[] arr = str.toCharArray();
	            for (int i = 0; i < arr.length; i++){
	                for (char c = 'a'; c <= 'z'; c++){
	                    char old = arr[i];
	                    arr[i] = c;
	                    String newStr = new String(arr);
	                    
	                    if (end.contains(newStr)){
	                        return len+1;
	                    }
	                    
	                    if (!visited.contains(newStr) && wordList.contains(newStr)){
	                        tmp.add(newStr);
	                        visited.add(newStr);
	                    }
	                    arr[i] = old;
	                }
	            }
	        }
	        begin = tmp;
	        len++;
	    }
	    return 0;
    }
}

