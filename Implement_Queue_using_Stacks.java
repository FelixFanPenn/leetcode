class Queue {
public:
    // Push element x to the back of queue.
    stack<int> stack1;
    stack<int> stack2;
    
    void transfer(){
        if (stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
    }
    
    void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    void pop(void) {
        transfer();
        stack2.pop();
    }

    // Get the front element.
    int peek(void) {
        transfer();
        return stack2.top();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return stack1.empty() && stack2.empty();
    }
};
