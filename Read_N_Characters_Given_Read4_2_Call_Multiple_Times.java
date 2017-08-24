/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    int bufferCnt = 0, bufferPtr = 0;
    char[] buff = new char[4];
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (bufferPtr == 0) {
                bufferCnt = read4(buff);
            }
            if (bufferCnt == 0) break;
            
            while (ptr < n && bufferPtr < bufferCnt) {
                buf[ptr++] = buff[bufferPtr++];
            }
            
            if (bufferCnt == bufferPtr) bufferPtr = 0;
        }
        
        return ptr;
    }
}