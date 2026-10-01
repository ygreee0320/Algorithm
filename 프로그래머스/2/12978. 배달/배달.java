import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int INF = 1_000_000_000;
        int[][] graph = new int[N + 1][N + 1];
        int[] cost = new int[N + 1]; // 최소 거리
        
        for (int[] g : graph) {
            Arrays.fill(g, INF);
        }
        
        // 같은 두 마을 사이에 도로가 여러 개면 가장 짧은 도로만 저장
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int time = r[2];

            graph[a][b] = Math.min(graph[a][b], time);
            graph[b][a] = Math.min(graph[b][a], time);
        }
        
        Arrays.fill(cost, INF);
        cost[1] = 0;
        
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 0; i < N; i++) {
            int current = -1; // 아직 확정하지 않은 마을 중 거리가 가장 짧은 마을
            
            for (int node = 1; node <= N; node++) {
                if (!visited[node] && (current == -1 || cost[node] < cost[current])) {
                    current = node;
                }
            }
            
            if (current == -1 || cost[current] == INF) break;
            visited[current] = true;
            
            for (int next = 1; next <= N; next++) {
                if (graph[current][next] == INF) continue;
                
                int newCost = cost[current] + graph[current][next];
                if (newCost < cost[next]) {
                    cost[next] = newCost;
                }
            }
        }
        
        int answer = 0;
        for (int c : cost) {
            if (c <= K) answer++;
        }

        return answer;
    }
}