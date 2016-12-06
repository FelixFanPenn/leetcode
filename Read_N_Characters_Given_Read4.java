/* The read4 API is defined in the parent class Reader4
	int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int hasRead = 0, justRead = 0;
        
        while(true){
            
            justRead = read4(buffer);
            int toRead = Math.min(justRead, n - hasRead);
            
            for (int i = 0; i < toRead; i++){
                buf[i + hasRead] = buffer[i];
            }
            
            hasRead += toRead;
            
            if (toRead < 4 || hasRead >= n){
                return hasRead;
            }
            
        }
    }
}
