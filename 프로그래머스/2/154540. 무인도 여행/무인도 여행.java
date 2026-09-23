import java.util.*;

class Solution {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, 1, -1, 0};
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'X') continue;
                
                if (!visited[i][j]) {
                    result.add(bfs(maps, i, j));
                }
            }
        }
        
        if (result.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(result);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private int bfs(String[] maps, int start_x, int start_y) {
        int n = maps.length;
        int m = maps[0].length();
        int cnt = maps[start_x].charAt(start_y) - '0';
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{start_x, start_y});
        visited[start_x][start_y] = true;
        
        while(!q.isEmpty()) {
            int[] next = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = next[0] + dx[i];
                int ny = next[1] + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    cnt += maps[nx].charAt(ny) - '0';
                    visited[nx][ny] = true;
                }
            }
        }
        
        return cnt;
    }
}