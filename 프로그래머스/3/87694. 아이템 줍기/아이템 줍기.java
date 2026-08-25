import java.util.*;

class Solution {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    
    private int[][] board = new int[102][102];
    private int[][] distance = new int[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 모든 사각형 영역 채우기 (테두리 포함)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
        }
        
        // 사각형 내부 지우기 (테두리만 남기기)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    board[x][y] = 0;
                }
            }
        }
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        int targetX = itemX * 2;
        int targetY = itemY * 2;
        
        int answer = bfs(startX, startY, targetX, targetY) / 2;
        return answer;
    }
    
    private int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{startX, startY});
        distance[startX][startY] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            
            int x = current[0];
            int y = current[1];
            
            if (x == targetX && y == targetY) {
                return distance[x][y] - 1;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= 102 || ny < 0 || ny >= 102) {
                    continue;
                }
                
                if (board[nx][ny] != 1 || distance[nx][ny] != 0) {
                    continue;
                }
                
                distance[nx][ny] = distance[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        return -1;
    }
}