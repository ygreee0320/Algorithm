import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, 1});
        maps[0][0] = -1; // 방문
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while (!q.isEmpty()) {
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];
            int z = next[2];
            
            if (x == n - 1 && y == m - 1) {
                return z;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1) {
                        maps[nx][ny] = -1;
                        q.add(new int[]{nx, ny, z + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}