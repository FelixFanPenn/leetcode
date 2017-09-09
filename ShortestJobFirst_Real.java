
import java.util.*;
public class ShortestJobFirst_ {
    static class Process
    {
        int arrTime;
        int exeTime;
        public Process(int arrTime, int exeTime)
        {
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }
    public static double SJL(int[] req, int[] dur)
    {
        if(req == null || req.length == 0) return 0;
        PriorityQueue<Process> queue = new PriorityQueue<>(new Comparator<Process>()
        {
            @Override
            public int compare(Process a, Process b)
            {
                if(a.exeTime == b.exeTime) return a.arrTime - b.arrTime;
                else return a.exeTime - b.exeTime;
            }
        });
        int t = 0, sum = 0, i = 0;
        while(i < req.length || !queue.isEmpty())
        {
            if(queue.isEmpty())
            {
                queue.offer(new Process(req[i], dur[i]));
                t = req[i];
                i++;
            }
            else
            {
                Process p = queue.poll();
                sum += (t - p.arrTime);
                t += p.exeTime;
                while(i < req.length && req[i] <= t)
                {
                    queue.offer(new Process(req[i], dur[i]));
                    i++;
                }
            }
            System.out.println(sum);
            System.out.println(t);
            System.out.println();
        }
        return (sum + 0.0) / (1.0 * req.length);
    }
    public static void main(String[] args)
    {
    	int[] req = {1, 3, 3, 6, 6, 6, 7};
        int[] dur = {2 ,2 ,3 ,2, 4, 4, 2};
        System.out.println(SJL(req, dur));
    }
}