public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i <= rowIndex; i++){
            res.add(1);
            for (int j = i; j >= 0; j--){
                if (j != i && j != 0){
                    res.set(j, res.get(j) + res.get(j-1));
                }
            }
        }
        return res;
    }
}
