public class Solution {
    public int lengthLongestPath(String input) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        map.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.indexOf(".") != -1) {
                max = Math.max(max, len + map.get(level));
            } else {
                map.put(level + 1, len + 1 + map.get(level));
            }
        }
        return max;
    }
}