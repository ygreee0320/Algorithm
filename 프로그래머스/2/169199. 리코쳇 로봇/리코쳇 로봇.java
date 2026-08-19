import java.util.*;

class Solution {
    public int solution(String[] board) {
        int N = board.length;
        int M = board[0].length();
        char[][] newBoard = new char[N][M];
        
        int[] goal = new int[2];
        int[] start = new int[2];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newBoard[i][j] = board[i].charAt(j);
                if (newBoard[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (newBoard[i][j] == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] next = q.poll();
            
            if (next[0] == goal[0] && next[1] == goal[1]) {
                return next[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = next[0] + dx[i];
                int ny = next[1] + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || newBoard[nx][ny] == 'D') {
                    continue;
                }
                
                boolean flag = false; // 가로막힘 여부
                
                while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || newBoard[nx][ny] == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        
                        if (!visited[nx][ny]) {
                            q.add(new int[]{nx, ny, next[2] + 1});
                            visited[nx][ny] = true;
                            flag = true;
                        }
                        
                        break;
                    }
                }
                
                if (!flag) {
                    if (!visited[nx][ny]) {
                        q.add(new int[]{nx, ny, next[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}