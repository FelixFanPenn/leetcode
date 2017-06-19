public class MedianFinder {
    
    PriorityQueue<Integer> max, min;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        
        
        max = new PriorityQueue<>(new Comparator<Integer>() {
            
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
            
        });
       
        
        //max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if (min.size() > max.size()) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) * 0.5;
        } else {
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */