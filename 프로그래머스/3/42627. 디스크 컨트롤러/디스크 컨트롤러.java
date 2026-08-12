import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int[][] tasks = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            tasks[i][0] = i;
            tasks[i][1] = jobs[i][0];
            tasks[i][2] = jobs[i][1];
        }
        
        // 요청 시간 순으로 정렬
        Arrays.sort(tasks, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        // 소요시간, 요청시간, 번호 순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[2] != b[2]) {
                    return a[2] - b[2];
                } else if (a[1] != b[1]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        );
        
        int time = 0;
        int idx = 0;
        int completed = 0;
        int total = 0;
        
        while (completed < n) {
            // 현재 시간까지 요청된 작업들 추가
            while (idx < n && tasks[idx][1] <= time) {
                pq.offer(tasks[idx]);
                idx++;
            }
            
            // 현재 실행할 수 있는 작업이 없는 경우
            if (pq.isEmpty()){
                time = tasks[idx][1];
                continue;
            }
            
            int[] current = pq.poll();
            
            time += current[2];
            total += time - current[1];
            completed++;
        }
        
        return total / n;
    }
}