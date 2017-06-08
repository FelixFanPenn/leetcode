public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        backtrack(list, word, 0, 0, "");
        return list;
    }
    
    public void backtrack(List<String> list, String word, int index, int count, String str){
        if (index == word.length()) {
            if (count > 0) list.add(str + count);
            else list.add(str);
            return;
        } else {
            backtrack(list, word, index+1, count+1, str);
            backtrack(list, word, index+1, 0, str + (count > 0? count : "") + word.charAt(index));
        }
    }
}