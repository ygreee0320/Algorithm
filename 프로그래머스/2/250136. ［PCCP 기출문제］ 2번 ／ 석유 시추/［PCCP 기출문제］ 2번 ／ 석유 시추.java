import java.util.*;

class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        // 각 열별로 시추관을 뚫었을 때 얻을 수 있는 총 석유량
        int[] oilSum = new int[m];
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, visited, i, j, oilSum);
                }
            }
        }
        
        int answer = 0;
        
        for (int o : oilSum) {
            answer = Math.max(answer, o);
        }
        
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visited, int start_n, int start_m, int[] oilSum) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_n, start_m});
        visited[start_n][start_m] = true;
        
        int cnt = 0;
        Set<Integer> columns = new HashSet<>(); // 이 덩어리가 걸쳐있는 열 번호들
        
        while (!q.isEmpty()) {
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];
            
            cnt++;
            columns.add(y);
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        for (int c : columns) {
            oilSum[c] += cnt;
        }
    }
}