import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        
        for (int i = 0; i < players.length; i++) {
            int n = q.size();
            
            if (players[i] >= (n + 1) * m) { // 증설
                int over_cnt = players[i] - (n * m);
                
                while (over_cnt >= m) {
                    q.offer(i);
                    over_cnt -= m;
                    answer++;
                    System.out.println(i);
                }
            }
            
            while (!q.isEmpty()) {
                if ((i - q.peek() + 1) == k) {
                    q.poll();
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}