import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int m = storage.length;
        int n = storage[0].length();
        int answer = n * m;
        
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        
        char[][] grid = new char[m][n];
        
        for (char[] g : grid) {
            Arrays.fill(g, '.');
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = storage[i].charAt(j);
            }
        }
        
        for (String request : requests) {
            char target = request.charAt(0);
            
            if (request.length() > 1) { // 크레인
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == target) {
                            grid[i][j] = '.'; // 제거
                            answer--;
                        }
                    }
                }
            } else { // 지게차
                Queue<int[]> q = new LinkedList<>();
                List<int[]> toRemove = new ArrayList<>();
                boolean[][] visited = new boolean[m][n];
                
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i != 0 && j != 0 && i != m - 1 && j != n - 1) continue;
                        if (grid[i][j] == '.') {
                            q.add(new int[]{i, j});
                        } else if (grid[i][j] == target) {
                            toRemove.add(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
                
                while (!q.isEmpty()) {
                    int[] next = q.poll();
                
                    for (int i = 0; i < 4; i++) {
                        int nx = next[0] + dx[i];
                        int ny = next[1] + dy[i];
                                
                        if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                            if (grid[nx][ny] == target) {
                                toRemove.add(new int[]{nx, ny});
                            } else if (grid[nx][ny] == '.') {
                                q.add(new int[]{nx, ny});
                            }
                            
                            visited[nx][ny] = true;
                        }
                    }
                }
                
                for (int[] p : toRemove) {
                    grid[p[0]][p[1]] = '.';
                    answer--;
                }
            }
        }
        
        return answer;
    }
}