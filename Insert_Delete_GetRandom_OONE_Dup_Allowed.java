public class RandomizedCollection {

    List<Integer> list = new ArrayList<>();
    Map<Integer, LinkedHashSet<Integer>> map =new HashMap<>();
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        boolean b = false;
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());
            b = true;
        }
        map.get(val).add(list.size()-1);
        return b;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        LinkedHashSet<Integer> valSet = map.get(val);
        int indexToBeReplaced = valSet.iterator().next();
        
        int numAtLastPlace = list.get(list.size()-1);
        LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace);
        
        list.set(indexToBeReplaced, numAtLastPlace);
        valSet.remove(indexToBeReplaced);
        
        if (indexToBeReplaced != list.size()-1) {
            replaceWith.remove(list.size()-1);
            replaceWith.add(indexToBeReplaced);
        }
        list.remove(list.size()-1);
        if (valSet.isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */