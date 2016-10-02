public class Solution {
    public String reverseVowels(String s) {
        if (s.length() < 2) return s;
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); 
        vowels.add('o'); vowels.add('u'); vowels.add('A'); 
        vowels.add('E'); vowels.add('I'); vowels.add('O');vowels.add('U'); 
        
        char[] str = s.toCharArray();     // string to char array
        int left = 0, right = s.length()-1;
        while(left < right){
            while (!vowels.contains(str[left]) && left < right) left++;
            while (!vowels.contains(str[right]) && left < right) right--;
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++; right--;
        }
        return String.valueOf(str);   // convert char array to string
    }
}
