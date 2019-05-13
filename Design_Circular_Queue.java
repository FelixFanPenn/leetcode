class MyCircularQueue {

    int [] store = null;
    int front = 0 ;
    int back = 0;
    int size = 0;
    boolean full = false;
    boolean empty = true;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.store = new int[k] ;
        this.size = k ; 
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            store[back] = value;
            back = (back + 1) % size;
            if (back == front) 
                full = true;
            empty = false;
            return true;
        }
        return false;    
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            front = (front + 1) % size;
            if (back == front) 
                empty = true;
            full = false;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (!isEmpty())
            return store[front];
        return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (!isEmpty())
            return store[(back == 0 ? size - 1 : back - 1)];
        return -1 ;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return empty;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return full;
    }
}