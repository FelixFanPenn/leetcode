public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        char[] arr = s.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        
        for (int i = 0; i < arr.length-1; i++){
            if (arr[i] == arr[i+1]){
                if (arr[i] == '+') {
                    arr[i] = '-';
                    arr[i+1] = '-';
                    res.add(String.valueOf(arr));
                    arr[i] = '+';
                    arr[i+1] = '+';
                }
            }
        }
        
        return res;
    }
}
