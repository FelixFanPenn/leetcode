public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int count = 0, index = 0;
        boolean b = false;
        for (int i = 0; i < g.length; i++){
            for (int j = index; j < s.length; j++){
                if (s[j] >= g[i]){
                    b = true;
                    count++;
                    index = j+1;
                    break;
                }
            }
            if (!b) break;
            b = false;
        }
        return count;
    }
}

/*
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int count = 0, index = 0;
        boolean b = false;
        for (int i = 0; i < s.length; i++){
            for (int j = index; j < g.length; j++){
                if (s[i] >= g[j]){
                    count++;
                    index = j+1;
                    b = true;
                    break;
                }
            }
        }
        return count;
    }
}
*/