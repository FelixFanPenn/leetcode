public class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words.size() == 0) return true;
        int len = words.size();
        for (int i = 0; i < len; i++){
            String str = words.get(i);
            int size = str.length();
            for (int j = 0; j < size; j++){
                if (j >= len) return false;
                String tmp = words.get(j);
                if (i >= tmp.length()) return false;
                if (str.charAt(j) != tmp.charAt(i)) return false;
            }
        }
        return true;
    }
}