public class Solution {
    public int nthUglyNumber(int n) {
        int cur = 1;
        int first = 1, second = 1, third = 1;
        ArrayList<Integer> ugly = new ArrayList<>();
        ugly.add(0);
        ugly.add(1);
        
        while (n > 1){
            cur = Math.min(Math.min(ugly.get(first)*2, ugly.get(second)*3), ugly.get(third)*5);
            ugly.add(cur);
            
            if (cur == ugly.get(first)*2) first++;
            if (cur == ugly.get(second)*3) second++;
            if (cur == ugly.get(third)*5) third++;
            n--;
        }
        return ugly.get(ugly.size()-1);
    }
}
