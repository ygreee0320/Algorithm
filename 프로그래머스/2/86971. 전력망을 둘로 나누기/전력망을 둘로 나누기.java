import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            
            int countU = bfs(graph, n, u, v);
            int countV = Math.abs(n - countU);
            
            answer = Math.min(answer, Math.abs(countU - countV));
        }
        
        return answer;
    }
    
    private int bfs(List<List<Integer>> graph, int n, int u, int v) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(u);
        visited[u] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            
            for (int next : graph.get(current)) {
                if (next == v) continue;
                
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        
        return count;
    }
}