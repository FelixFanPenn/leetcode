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
    public int minMeetingRooms(Interval[] intervals) {
        /*
        if (intervals.length == 0) return 0;
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
        
        HashSet<Interval> set = new HashSet<>();
        int num = 1;
        for (int i = 0; i < array.size(); i++){
            int start = array.get(i).start;
            int count = 1;
            for (Interval interval : set){
                if (interval.end > start){
                    count++;
                }
            }
            num = Math.max(num, count);
            set.add(array.get(i));
        }
         
        return num;
        */
        
        if (intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });
        
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>(){
            @Override
            public int compare(Interval in1, Interval in2){
                return in1.end - in2.end;
            }
        });
        
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = queue.poll();
            if (intervals[i].start >= interval.end){
                interval.end = intervals[i].end;
            } else {
                queue.offer(intervals[i]);
            }
            queue.offer(interval);
        }
        return queue.size();
    }
}
