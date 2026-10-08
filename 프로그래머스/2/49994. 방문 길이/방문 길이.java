class Solution {
    public int solution(String dirs) {
        // U, D, R, L
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        boolean[][][] visited = new boolean[11][11][4];
        
        int answer = 0;
        int x = 5;
        int y = 5;
        
        for (int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            int order;
            int reverse_order;
            
            if (d == 'U') {
                order = 0;
                reverse_order = 1;
            } else if (d == 'D') {
                order = 1;
                reverse_order = 0;
            } else if (d == 'R') {
                order = 2;
                reverse_order = 3;
            } else {
                order = 3;
                reverse_order = 2;
            }
            
            int nx = x + dx[order];
            int ny = y + dy[order];
            
            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
            
            if (!visited[x][y][order]) {
                visited[x][y][order] = true;
                visited[nx][ny][reverse_order] = true;
                x = nx;
                y = ny;
                answer++;
            } else {
                x = nx;
                y = ny;
            }
        }
        
        return answer;
    }
}