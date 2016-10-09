/*
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < citations.length; i++){
            if (len <= citations[i]){
                return len;
            } else {
                len--;
            }
        }
        return 0;
    }
}
*/

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] bucket = new int[len+1];
        
        for (int i : citations){
            if (i > len){
                bucket[len]++;
            } else {
                bucket[i]++;
            }
        }
        
        int total = 0;
        
        for (int i = len; i >= 0; i--){
            total += bucket[i];
            if (total >= i){
                return i;
            }
        }
        
        return 0;
    }
}
