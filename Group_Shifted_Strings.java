public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        
        for (String str : strings){
            String key = getKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        
        return list;
    }
    
    String getKey(String str){
        String key = "";
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++){
            int k = str.charAt(i) - c;
            if (k >= 0) {
                key += (char)k;
            } else {
                key += (char)(k + 26);
            }
        }
        return key;
    }
}