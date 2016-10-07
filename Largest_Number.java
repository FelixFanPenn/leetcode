public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        
        int len = nums.length;
        String[] str = new String[len];
        
        for (int i = 0; i < len; i++){
            str[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comparator = new Comparator<String>(){ /// customized comparator
            @Override
            public int compare(String s1, String s2){
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);  // larger strings should be sorted to front
            }
        };
        Arrays.sort(str, comparator);
        
        if(str[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : str){
            sb.append(s);
        }
        return sb.toString();
    }
}
