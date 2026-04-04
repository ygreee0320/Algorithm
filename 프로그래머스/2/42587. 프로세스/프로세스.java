import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int p : priorities) {
            queue.add(p);
        }
        
        int[] sortedP = priorities;
        Arrays.sort(sortedP);
        
        //int idx = priorities.length - 1;
        int answer = 0;
        int location_idx = location;
        int priority_idx = sortedP.length - 1;
        
        while (!queue.isEmpty()) {
            int next = queue.poll();
            
            if (next == sortedP[priority_idx]) {
                answer++;
                priority_idx--;
                if (location_idx == 0) break;
            } else {
                queue.add(next);
            }
            
            location_idx = (location_idx - 1);
            
            if (location_idx < 0) {
                location_idx = queue.size() - 1;
            }
        }
        
        return answer;
    }
}