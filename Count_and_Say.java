public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++){
            res = generateNext(res);
        }
        return res;
    }
    
    public String generateNext(String res){
        int len = res.length(), i = 0;
        String tmp = "";
        while (i < len){
            int count = 1;
            while (i < len-1 && res.charAt(i) == res.charAt(i+1)){
                i++;
                count++;
            }
            tmp += count + "";
            tmp += res.charAt(i++);
        }
        return tmp;
    }
}