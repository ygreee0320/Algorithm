import java.util.*;

class Solution {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, 1, -1, 0};
    
    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        int time_lever = bfs(start, lever, maps);
        int time_exit = bfs(lever, exit, maps);
        
        if (time_lever == -1 || time_exit == -1) {
            return -1;
        } else {
            return time_lever + time_exit;
        }
    }
    
    private int bfs(int[] start, int[] end, String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        boolean[][] visited = new boolean[N][M];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];
            int time = next[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    if (nx == end[0] && ny == end[1]) {
                        return time + 1;
                    } else {
                        q.add(new int[]{nx, ny, time + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}