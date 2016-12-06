/* The read4 API is defined in the parent class Reader4
	int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    private int buffPtr = 0;
    private int buffCur = 0;
    private char[] buff = new char[4];
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n){
            if (buffPtr == 0){
                buffCur = read4(buff);
            }
            
            while (ptr < n && buffPtr < buffCur){
                buf[ptr++] = buff[buffPtr++];
            }
            
            if (buffPtr == buffCur){
                buffPtr = 0;
            }
            
            if (buffCur != 4){
                break;
            }
        }
        return ptr;
    }
}
