public class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        int countR = 0, countD = 0, count = 0;
        
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                q.offer('R');
                countR++;
            } else {
                q.offer('D');
                countD++;
            }
        }
        
        while (countR != 0 && countD != 0) {
            char c = q.poll();
            if (c == 'R') {
                count++;
                if (count > 0) {
                    countD--;
                    q.offer(c);
                }
            } else {
                count--;
                if (count < 0) {
                    countR--;
                    q.offer(c);
                }
            }
        }
        
        return countR == 0 ? "Dire" : "Radiant";
    }
}