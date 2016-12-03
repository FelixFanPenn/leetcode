public class RandomizedSet {
    
    HashMap<Integer, Integer> map;
    ArrayList<Integer> array;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        array = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        } else {
            map.put(val, array.size());
            array.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)){
            int tmp = map.get(val);
            
            if (tmp < array.size()-1){
                int last = array.get(array.size()-1);
                array.set(tmp, last);
                map.put(last, tmp);
            }
            
            map.remove(val);
            array.remove(array.size()-1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int random = rand.nextInt(array.size());
        return array.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
