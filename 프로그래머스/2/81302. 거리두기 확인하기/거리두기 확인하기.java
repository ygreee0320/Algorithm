import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            char[][] place = new char[5][5];
            
            for (int r = 0; r < 5; r++) {
                place[r] = places[i][r].toCharArray();
            }
            
            answer[i] = bfs(place) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean bfs(char[][] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r][c] == 'P') {
                    boolean[][] visited = new boolean[5][5];
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{r, c, 0});
                    visited[r][c] = true;
                    
                    while (!q.isEmpty()) {
                        int[] next = q.poll();
                        int distance = next[2] + 1;
                        
                        for (int k = 0; k < 4; k++) {
                            int nx = next[0] + dx[k];
                            int ny = next[1] + dy[k];
                            
                            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;
                            
                            if (place[nx][ny] == 'O' && distance < 2) {
                                q.add(new int[]{nx, ny, distance});
                            } else if (place[nx][ny] == 'P' && distance <= 2) {
                                return false;
                            }
                            
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}