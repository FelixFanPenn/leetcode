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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if (intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval inter1, Interval inter2){
                return inter1.start - inter2.start;
            }
        });
        
        /*   also work
        Comparator<Interval> comparator = new Comparator<Interval>(){
            @Override
            public int compare(Interval inter1, Interval inter2){
                return inter1.start - inter2.start;
            }
        };
        Collections.sort(intervals, comparator);
        */
        
        int start = intervals.get(0).start, end = intervals.get(0).end;
        
        for (Interval inter : intervals){
            if (inter.start <= end){
                end = Math.max(end, inter.end);
            } else {
                Interval tmp = new Interval(start, end);
                res.add(tmp);
                start = inter.start;
                end = inter.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
