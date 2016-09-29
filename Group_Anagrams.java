public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (int i = 0; i < strs.length; i++){
            ArrayList<Character> str = new ArrayList<Character>();
            char[] tmp = strs[i].toCharArray();
            
            Arrays.sort(tmp);
            for (char c : tmp){
                str.add(c);
            }

            if (!map.containsKey(str.toString())){
                map.put(str.toString(), new ArrayList<String>());
                map.get(str.toString()).add(strs[i]);
            } else {
                map.get(str.toString()).add(strs[i]);
            }
        }
        for (String key: map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
