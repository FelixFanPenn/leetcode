public class LFUCache {
    
    private int min = -1;
    private int cap;
    private HashMap<Integer, Integer> keyToVal = new HashMap<>();
    private HashMap<Integer, Integer> keyToCount = new HashMap<>();
    private HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys = new HashMap<>();
    
    public LFUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key);
        
        if (count == min && countToLRUKeys.get(count).size() == 0) min++;
        
        putCount(key, count+1);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (this.cap <= 0) return;
        
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            return;
        }
        
        if (keyToVal.size() >= this.cap) {
            evict(countToLRUKeys.get(min).iterator().next());
        }
        
        min = 1;
        putCount(key, min);
        keyToVal.put(key, value);
    }
    
    public void evict(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }
    
    public void putCount(int key, int count) {
        keyToCount.put(key, count);
        
        if (!countToLRUKeys.containsKey(count)) {
            countToLRUKeys.put(count, new LinkedHashSet<>());
        }
        
        countToLRUKeys.get(count).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */