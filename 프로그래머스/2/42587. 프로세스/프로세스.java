import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[1] == pq.peek()) {
                answer++;
                pq.poll();
                
                if (current[0] == location) {
                    return answer;
                }
            } else {
                queue.add(current);
            }
        }
        
        return answer;
    }
}