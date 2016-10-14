/*

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites.length <= 1 || prerequisites[0].length <= 1) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++){
            Set<Integer> set = new HashSet<>();
            map.put(i, set);
        }
        
        for (int i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int coursesRemaining = numCourses;
        
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            if (entry.getValue().size() == 0){
                queue.offer(entry.getKey());
                coursesRemaining--;
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
                if (entry.getValue().contains(course)){
                    entry.getValue().remove(course);
                    if (entry.getValue().size() == 0){
                        queue.offer(entry.getKey());
                        coursesRemaining--;
                    }
                }
            }
        }
        
        return coursesRemaining == 0;
    }
}
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0){
                indegree[ready]++;
            }
            matrix[pre][ready] = 1;
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++){
                if (matrix[course][i] != 0){
                    indegree[i]--;
                    if (indegree[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}

