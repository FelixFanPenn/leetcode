public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        class Project {
            int profit;
            int capital;
            Project(int p, int c) {
                profit = p;
                capital = c;
            }
        }
        
        PriorityQueue<Project> pq1 = new PriorityQueue<Project>(new Comparator<Project>(){
            @Override
            public int compare(Project p1, Project p2){
                return p2.profit - p1.profit;
            }
        });
        
        Set<Project> set = new HashSet<>();

        for (int i = 0; i < Profits.length; i++) {
            Project p = new Project(Profits[i], Capital[i]);
            pq1.add(p);
        }
        
        boolean b = true;
        while (k != 0 && b) {
            pq1.addAll(set);
            set.clear();
            b = false;
            while (!pq1.isEmpty()) {
                Project p = pq1.poll();
                if (p.capital <= W) {
                    k--;
                    W += p.profit;
                    b = true;
                    break;
                } else {
                    set.add(p);
                }
            }
        }
        return W;
    }
}