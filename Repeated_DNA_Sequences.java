public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> added = new HashSet<>();
        
        for (int i = 0; i < s.length()-9; i++){
            String tmp = s.substring(i, i+10);
            if (set.contains(tmp) && !added.contains(tmp)){
                res.add(tmp);
                added.add(tmp);
            } else {
                set.add(tmp);
            }
        }
        return res;
    }
}
