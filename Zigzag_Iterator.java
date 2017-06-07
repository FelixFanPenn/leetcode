public class ZigzagIterator {
    
    int len1, len2, i1 = 0, i2 = 0;
    boolean b = true;
    List<Integer> v1;
    List<Integer> v2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        len1 = v1.size();
        len2 = v2.size();
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (b) {
            if (i1 < len1) {
                int tmp = v1.get(i1++);
                b = false;
                return tmp;
            } else {
                int tmp = v2.get(i2++);
                b = true;
                return tmp;
            }
        } else {
            if (i2 < len2) {
                int tmp = v2.get(i2++);
                b = true;
                return tmp;
            } else {
                int tmp = v1.get(i1++);
                b = false;
                return tmp;
            }
        }
    }

    public boolean hasNext() {
        return i1 < len1 || i2 < len2;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */