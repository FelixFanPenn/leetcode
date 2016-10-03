public class LRUCache {
    
    private class Node{
        Node pre, next;
        int key, val;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
        
        public Node(){     // pay attention to this OO 
            this(-1, -1);
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToTail(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        if (get(key) != -1){
            map.get(key).val = value;
            return;
        }
        
        if (map.size() == this.capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node node){

        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}
