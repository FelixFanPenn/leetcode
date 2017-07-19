public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] res = new int[26];
        for (char c : tasks) {
            res[c - 'A']++;
        }
        Arrays.sort(res);
        int i = 25;
        while (i >= 0 && res[i] == res[25]) i--;
        
        return Math.max(tasks.length, (n+1) * (res[25] - 1) + 25 - i);
    }
}