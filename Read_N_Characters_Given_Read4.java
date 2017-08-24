/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int hasRead = 0, cur = 4;
        char[] buffer = new char[4];
        
        while (hasRead < n && cur == 4) {
            cur = read4(buffer);
            int i = 0;
            while (i < cur && hasRead < n) {
                buf[hasRead++] = buffer[i++];
            }
        }
        return hasRead;
    }
}