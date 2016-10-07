public class Solution {
    boolean isConnected = false;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
       
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);
        
        Map<String, List<String>> map = new HashMap<>();
        bfs(begin, end, map, false, wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        if(!isConnected) return res;
        
        List<String> temp = new ArrayList<String>();
        temp.add(beginWord);
        backtrack(beginWord, endWord, res, map, temp);
        
        return res;
    }
    
    private void bfs(Set<String> begin, Set<String> end, Map<String, List<String>> map, boolean swapped, Set<String> wordList){   
        
        if (begin.isEmpty() || end.isEmpty()) return;
        
        if (begin.size() > end.size()){
            bfs(end, begin, map, !swapped, wordList);
            return;
        }
        
        wordList.removeAll(begin);
        wordList.removeAll(end);
        
        Set<String> tmp = new HashSet<>();
        for (String str : begin){
            for (int i = 0; i < str.length(); i++){
                char[] arr = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c++){
                    arr[i] = c;
                    String newStr = new String(arr);
                    
                    if (!end.contains(newStr) && !wordList.contains(newStr)) continue;  // if the word is neither in end set nor in wordList
                    
                    String key = !swapped? str : newStr;   // depending on if we have switched begin and end sets
                    String value = !swapped? newStr : str;
                    
                    if (!map.containsKey(key)){           // if key is not in map
                        map.put(key, new ArrayList<String>());
                    }
                    
                    if (end.contains(newStr)){             // if we have reached from begin to end set
                        isConnected = true;
                        map.get(key).add(value);
                    } 
                    
                    if(!isConnected && wordList.contains(newStr)){   // if we have not reached end set but newStr is in wordList
                        map.get(key).add(value);
                        tmp.add(newStr);
                    }
                }
            }
        }
        if (!isConnected){  // keep going if not connected yet
            bfs(tmp, end, map, swapped, wordList);
            return;
        }
    }
    
    private void backtrack(String beginWord, String endWord, List<List<String>> res, Map<String, List<String>> map, List<String> tmp){
        if (beginWord.equals(endWord)){   // if we have reached the endWord
            res.add(new ArrayList<String>(tmp));
            return;
        }
        
        if (!map.containsKey(beginWord)) return;   // if we go into a dead end
        
        for (String str : map.get(beginWord)){     
            tmp.add(str);
            backtrack(str, endWord, res, map, tmp);   // backtrack
            tmp.remove(str); 
        }
    }

}
