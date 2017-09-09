public class GrayCode {
    public static boolean findGray(byte b1, byte b2) {
        byte b = (byte) (b1 ^ b2);
        
        int total = 0;
        while (b != 0) {
            b = (byte) (b & (b-1));
            total++;
        }
        if (total == 1) return true;
        return false;
    }
    
    public static boolean findGray_(byte b1, byte b2) {
        byte b = (byte) (b1 ^ b2);
        
        for (int i = 0; i <= 7; i++) {
            byte tmp = (byte) (1 << i);
            if (tmp == b) return true;

        }
        return false;
    }
}
