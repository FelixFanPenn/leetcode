public class StringIterator {
    
    private int i;
    private long rep;
    private char ch;
    private char[] cs;
    public StringIterator(String com) {
        cs = com.toCharArray();
    }
    
    public char next() {
        if (rep > 0) {
            rep--;
            return ch;
        } else {
            if (i >= cs.length) return ' ';
            ch = cs[i++];
            long num = 0;
            while (i < cs.length && Character.isDigit(cs[i])) {
                num = 10 * num + (cs[i] - '0');
                i++;
            }
            rep = num-1;
            return ch;
        }
    }
    
    public boolean hasNext() {
        return rep > 0 || i < cs.length;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */