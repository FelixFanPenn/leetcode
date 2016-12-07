/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        /*     solution of my own
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>(){
            @Override
            public int compare(Interval in1, Interval in2){
                return in1.start - in2.start;
            }
        });
        
        for (int i = 0; i < intervals.length; i++){
            queue.offer(intervals[i]);
        }
        
        ArrayList<Interval> array = new ArrayList<>();
        while (!queue.isEmpty()){
            array.add(queue.poll());
        }
        
        for (int i = 0; i < array.size()-1; i++){
            if (array.get(i+1).start < array.get(i).end) return false;
        }
        
        return true;
        */
        
        
        // solution from friends
        int len = intervals.length;
        int[] first = new int[len];
        int[] second = new int[len];
        for (int i = 0; i < len; i++){
            first[i] = intervals[i].start;
            second[i] = intervals[i].end;
        }
        
        Arrays.sort(first);
        Arrays.sort(second);
        
        for (int i = 0; i < len-1; i++){
            if (second[i] > first[i+1]){
                return false;
            }
        }
        return true;
    }
}
