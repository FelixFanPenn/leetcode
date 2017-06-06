/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int hasRead = 0, toRead = 0;
        
        while (true) {
            int tmp = read4(buffer);
            
            toRead = Math.min(n - hasRead, tmp);
            for (int i = 0; i < toRead; i++){
                buf[hasRead++] = buffer[i];
            }
            
            if (hasRead >= n || tmp == 0) break;
        }
        
        return hasRead;
    }
}
