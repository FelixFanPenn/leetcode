/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
    // sort
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
    // PriorityQueue
        PriorityQueue<Integer> ends = new PriorityQueue<Integer>();
        ends.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= ends.peek()) { // no overlap, then should update smallest end.
                ends.poll();
            }    
            ends.offer(intervals[i].end);
        }
        return ends.size();
    }
}

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int res = 0, len = intervals.length, endpos = 0;
        int[] a = new int[len];
        int[] b = new int[len];
        
        for (int i = 0; i < intervals.length; i++) {
            a[i] = intervals[i].start;
            b[i] = intervals[i].end;
        }
        
        Arrays.sort(a); Arrays.sort(b);
        
        for (int i = 0; i < len; i++) {
            if (a[i] < b[endpos]) {
                res++;
            } else {
                endpos++;
            }
        }
        
        return res;
        
    }
}