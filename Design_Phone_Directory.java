public class PhoneDirectory {
    
    Set<Integer> takenSet = new HashSet<>();
    Queue<Integer> avail = new LinkedList<>();
    int max;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++){
            //availSet.add(i);
            avail.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer ret = avail.poll();
        if (ret == null) {
            return -1;
        }
        takenSet.add(ret);
        return ret;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= max || number < 0) {
            return false;
        }
        return !takenSet.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (takenSet.remove(number)){
            avail.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */