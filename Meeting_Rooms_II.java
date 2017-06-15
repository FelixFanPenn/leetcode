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