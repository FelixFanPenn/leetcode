public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num < 6) return false;
        int sum = 1;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 2; i < Math.sqrt(num) + 1; i++){
            if (num % i == 0) {
                if (!set.contains(i)){
                    sum += i;
                    sum += num/i;
                    set.add(i);
                    set.add(num/i);
                }
            }
        }
        return sum == num;
    }
}