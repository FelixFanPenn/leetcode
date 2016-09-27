class MyStack {            // use two queues
    
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q2.poll();
    }

    // Get the top element.
    public int top() {
        return q2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q2.isEmpty();
    }
}

/*

class MyStack {          // use only one queue

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size()-1; i++){
            queue.add(queue.poll());
        }
    }

    public void pop() {
        queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
*/

