import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) pq.add(s);
        
        int answer = 0;
        
        while (pq.size() >= 2) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            if (s1 >= K) return answer;
            
            int mix_s = s1 + (s2 * 2);
            
            pq.add(mix_s);
            answer++;
        }
        
        if (pq.size() == 0) {
            return -1;
        } else {
            if (pq.poll() >= K) {
                return answer;
            } else {
                return -1;
            }
        }
    }
}