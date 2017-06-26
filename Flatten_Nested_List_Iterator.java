/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack1;
    List<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        stack1 = new Stack<>();
        pushToStack(list);
    }
    
    public void pushToStack (List<NestedInteger> l) {
        for (int i = l.size()-1; i >= 0; i--) {
            stack1.push(l.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        return stack1.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack1.isEmpty() && !stack1.peek().isInteger()) {
            pushToStack(stack1.pop().getList());
        }
        return !stack1.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
