public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        if (low.equals("0") && high.equals("0")) return 1;
        int len1 = 0, len2 = 0;
        long low1 = Long.parseLong(low), high1 = Long.parseLong(high);
        while (low1 > 0){
            len1++; low1 /= 10;
        }
        while (high1 > 0){
            len2++; high1 /= 10;
        }
        List<String> list = new ArrayList<>();
        for (int i = len1; i <= len2; i++){
            list.addAll(helper(i, i));
        }
        
        int count = 0;
        low1 = Long.parseLong(low);
        high1 = Long.parseLong(high);
        
        long i = 0;
        for (String str : list){
            if (str.equals("")) continue;
            else i = Long.parseLong(str);
            if (high1 >= i && i >= low1) count++;
        }
        
        return count;
    }
    
    public List<String> helper(int n, int m){
        if (m == 0) return new ArrayList<>(Arrays.asList(""));
        if (m == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        
        List<String> res = helper(n, m-2);
        List<String> list = new ArrayList<>();
        for (String str : res){
            
            if (m != n) {
                list.add("0" + str + "0");
            }
            
            list.add("1" + str + "1");
            list.add("8" + str + "8");
            list.add("6" + str + "9");
            list.add("9" + str + "6");
        }
        return list;
    }
}