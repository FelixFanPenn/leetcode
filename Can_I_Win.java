/*
public class Solution {
    public boolean canIWin(int max, int desire) {
        int sum = (1 + max) * max / 2;
        if (sum < desire) return false;
        return helper(new HashMap<String, Boolean>(), new int[max+1], desire);
    }
    
    public boolean helper(Map<String, Boolean> map, int[] keys, int desire) {
        String key = Arrays.toString(keys);
        if (map.containsKey(key)) return map.get(key);

        for (int i = 1; i < keys.length; i++) {
            if (keys[i] == 0) {
                keys[i] = 1;
                if (desire - i <= 0 || !helper(map, keys, desire - i)) {
                    map.put(key, true);
                    keys[i] = 0;
                    return true;
                }
                keys[i] = 0;
            }
        }
        
        map.put(key, false);
        return false;
    }
}
*/

public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal<=0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        return canIWin(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
    }
    private boolean canIWin(int total, int n, int state, HashMap<Integer, Boolean> hashMap) {
        if (hashMap.containsKey(state)) return hashMap.get(state);
        for (int i=0;i<n;i++) {
            if ((state&(1<<i))!=0) continue;
            if (total<=i+1 || !canIWin(total-(i+1), n, state|(1<<i), hashMap)) {
                hashMap.put(state, true);
                return true;
            }
        }
        hashMap.put(state, false);
        return false;
    }
}