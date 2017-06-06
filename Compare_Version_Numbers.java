public class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int s1 = 0, s2 = 0, e1 = 0, e2 = 0, v1 = 0, v2 = 0;
        while (s1 < len1 || s2 < len2){
            while (e1 < len1 && version1.charAt(e1) != '.') {
                e1++;
            }
            while (e2 < len2 && version2.charAt(e2) != '.') {
                e2++;
            }
            
            if (s1 == e1) {
                v1 = 0;
            } else {
                v1 = Integer.parseInt(version1.substring(s1, e1));
            }
            
            if (s2 == e2) {
                v2 = 0;
            } else {
                v2 = Integer.parseInt(version2.substring(s2, e2));
            }
            
            if (v1 > v2) return 1;
            else if (v2 > v1) return -1;
            
            s1 = ++e1;
            s2 = ++e2;
            
        }
        return 0;
    }
}