public class TwoSum {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    int value = map.containsKey(number)? map.get(number) : 0;
	    map.put(number, value+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Integer integer : map.keySet()){
	        int num = value - integer;
	        
	        if (num == integer){
	            if (map.get(num) >= 2){
	                return true;
	            }
	        } else {
	            if (map.containsKey(num)){
	                return true;
	            }
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
