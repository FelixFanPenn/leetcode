class MyLinkedList {
        final Node head = new Node(0), tail = new Node(0);
        int len;

        public MyLinkedList() { 
            head.next = tail;
        }

        public int get(int i) {
            if (i >= len) return -1;
            Node node = findPrev(i);
            return node.next.val;
        }

        public void addAtHead(int val) { 
            addAtIndex(0, val);
        }

        public void addAtTail(int val) { 
            addAtIndex(len, val);
        }

        public void addAtIndex(int i, int val) {
            if (i > len) return;
            Node prev = findPrev(i), next = prev.next;
            prev.next = new Node(val);
            prev.next.next = next;
            len++;
        }

        public void deleteAtIndex(int i) {
            if (i >= len) return;
            Node prev = findPrev(i);
            prev.next = prev.next.next;
            len--;
        }

        private Node findPrev(int i) {
            Node node = head;
            while (i-- > 0)
                node = node.next;
            return node;
        }

        class Node {
            int val;
            Node next;

            Node(int val) { 
                this.val = val;
            }
        }
}
