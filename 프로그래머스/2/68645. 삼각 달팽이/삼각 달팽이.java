class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        
        int type = 0; // 0: 아래로, 1: 옆으로, 2: 위로
        int number = 1;
        int x = 0; // 높이(역순)
        int y = 0;
        
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                total++;
            }
        }
        
        while (number <= total) {
            if (type == 0) { // 아래로 +1
                while (x < n) {
                    map[x][y] = number;
                    number++;
                    
                    if ((x == n - 1) || ((x + 1) < n && map[x + 1][y] != 0)) {
                        y++;
                        break;
                    }
                    
                    x++;
                }
            }
            
            else if (type == 1) { // 옆으로 +1
                while (y  < n) {
                    map[x][y] = number;
                    number++;
                    
                    if ((y == n - 1) || ((y + 1) < n && map[x][y + 1] != 0)) {
                        x--;
                        y--;
                        break;
                    }
                    
                    y++;
                }
            }
            
            else { // 위로 +1
                while (x > 0 && y > 0) {
                    map[x][y] = number;
                    number++;
                    
                    if ((map[x - 1][y - 1] != 0)) {
                        x++;
                        break;
                    }
                    
                    x--;
                    y--;
                }
            }
            
            type = (type + 1) % 3;
        }
        
        int[] answer = new int [total];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}