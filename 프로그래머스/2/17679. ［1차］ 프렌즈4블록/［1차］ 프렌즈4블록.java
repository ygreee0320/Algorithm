import java.util.*;

class Solution {
    int[] dx = {0, 1, 1};
    int[] dy = {1, 0, 1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while (true) {
            Queue<int[]> remove_q = new LinkedList<>();
            
            // 지울 블록 판별
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char target = map[i][j];
                    if (target == '.') continue;
                    
                    boolean isEqual = true;
                    
                    for (int k = 0; k < 3; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if (target != map[nx][ny]) {
                            isEqual = false;
                        }
                    }
                    
                    if (isEqual) {
                        remove_q.add(new int[]{i, j});
                        
                        for (int k = 0; k < 3; k++) {
                            remove_q.add(new int[]{i + dx[k], j + dy[k]});
                        }
                    }
                }
            }
            
            if (remove_q.isEmpty()) break;
            
            // 블록 제거
            while (!remove_q.isEmpty()) {
                int[] next = remove_q.poll();
                
                if (map[next[0]][next[1]] != '.') {
                    map[next[0]][next[1]] = '.';
                    answer++;
                }
            }
            
            // 빈 공간 채우기
            for (int i = 0; i < n; i++) {
                Queue<Character> move_q = new LinkedList<>();
                
                // 살아있는 블록 아래부터 저장
                for (int j = m - 1; j >= 0; j--) { 
                    if (map[j][i] != '.') {
                        move_q.add(map[j][i]);
                    }
                }
                
                for (int j = m - 1; j >= 0; j--) {
                    if (!move_q.isEmpty()) {
                        char next = move_q.poll();
                        
                        map[j][i] = next;
                    } else {
                        map[j][i] = '.';
                    }
                }
            }
        }
        
        return answer;
    }
}