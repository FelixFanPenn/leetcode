import java.util.ArrayList;
import java.util.List;

public class LRU_Cache_Count_Miss {
    // size is the size of cache
    public int solution(int[] arr, int size) {
        if (arr == null || arr.length == 0) return 0;
        List<Integer> cache = new ArrayList<>();
        int miss = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (cache.contains(arr[i])) {
                cache.remove(new Integer(arr[i]));
            } else {
                miss++;
                if (cache.size() == size) cache.remove(0);
            }
            cache.add(new Integer(arr[i]));
        }
        
        return miss;
    }
}
