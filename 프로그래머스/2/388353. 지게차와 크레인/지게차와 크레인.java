import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int m = storage.length;
        int n = storage[0].length();
        int answer = n * m;
        
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        
        char[][] grid = new char[m + 2][n + 2];
        
        for (char[] g : grid) {
            Arrays.fill(g, '.');
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        for (String request : requests) {
            char target = request.charAt(0);
            
            if (request.length() > 1) { // 크레인
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i + 1][j + 1] == target) {
                            grid[i + 1][j + 1] = '.'; // 제거
                            answer--;
                        }
                    }
                }
            } else { // 지게차
                Queue<int[]> remove_q = new LinkedList<>(); // 주변 업데이트할 컨테이너
                Queue<int[]> q = new LinkedList<>(); // 탐색할 컨테이너
                
                boolean[][] visited = new boolean[m + 2][n + 2];
                
                q.add(new int[]{0, 0});
                visited[0][0] = true;
                
                while (!q.isEmpty()) {
                    int[] next = q.poll();
                
                    for (int i = 0; i < 4; i++) {
                        int nx = next[0] + dx[i];
                        int ny = next[1] + dy[i];
                                
                        if (nx >= 0 && ny >= 0 && nx < m + 2 && ny < n + 2 && !visited[nx][ny]) {
                            if (grid[nx][ny] == target) {
                                remove_q.add(new int[]{nx, ny});
                            } else if (grid[nx][ny] == '.') {
                                q.add(new int[]{nx, ny});
                            }
                            
                            visited[nx][ny] = true;
                        }
                    }
                }
                
                while (!remove_q.isEmpty()) {
                    int[] next = remove_q.poll();
                    
                    if (grid[next[0]][next[1]] == '.') {
                        continue;
                    }
                    
                    grid[next[0]][next[1]] = '.';
                    answer--;
                }
            }
        }
        
        return answer;
    }
}