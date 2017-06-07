public class MovingAverage {
    
    Queue<Integer> q;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        if (q.size() >= size) {
            int tmp = q.poll();
            sum -= tmp;
        }
        q.offer(val);
        sum += val;
        
        return sum * 1.0 / (q.size() * 1.0);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */