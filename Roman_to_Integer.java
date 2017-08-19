class Solution {
    public int romanToInt(String s) {
        int sum = 0, len = s.length();
        int[] arr = new int[len];
        
        for (int i = 0; i < len; i++) {
            switch(s.charAt(i)) {
                case 'M':
                    arr[i] = 1000;
                    break;
                case 'D':
                    arr[i] = 500;
                    break;
                case 'C':
                    arr[i] = 100;
                    break;
                case 'L':
                    arr[i] = 50;
                    break;
                case 'X':
                    arr[i] = 10;
                    break;
                case 'V':
                    arr[i] = 5;
                    break;
                case 'I':
                    arr[i] = 1;
                    break;
            }
        }
        
        for (int i = 0; i < len-1; i++) {
            if (arr[i] < arr[i+1]) {
                sum -= arr[i];
            } else {
                sum += arr[i];
            }
        }
        return sum + arr[len-1];
    }
}