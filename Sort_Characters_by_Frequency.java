public class Solution {
    
    public String frequencySort(String s) {
        class Char{
            char c;
            int time;
        }
        
        Map<Character, Char> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Char cha = map.get(c);
                cha.time++;
                map.put(c, cha);
            } else {
                Char cha = new Char();
                cha.c = c;
                cha.time = 1;
                map.put(c, cha);
            }
        }
        
        PriorityQueue<Char> pq = new PriorityQueue<Char>(new Comparator<Char>(){
            public int compare(Char n1, Char n2) {
                return n2.time - n1.time;
            }
        });
        
        for (char c : map.keySet()) {
            pq.add(map.get(c));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Char tmp = pq.poll();
            for (int i = 0; i < tmp.time; i++) {
                sb.append(tmp.c);
            }
        }
        return sb.toString();
    }
}