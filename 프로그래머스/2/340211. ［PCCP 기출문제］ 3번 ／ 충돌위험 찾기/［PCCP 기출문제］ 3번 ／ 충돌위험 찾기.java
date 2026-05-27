import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<int[]>[] paths = new ArrayList[routes.length];
        
        for (int i = 0; i < routes.length; i++) { // 로봇 번호
            paths[i] = new ArrayList<>();
            
            int[] current_route = routes[i];
            paths[i].add(new int[]{points[current_route[0] - 1][0], points[current_route[0] - 1][1]});
            
            for (int j = 1; j < current_route.length; j++) {
                int start_r = points[current_route[j - 1] - 1][0];
                int start_c = points[current_route[j - 1] - 1][1];
                int end_r = points[current_route[j] - 1][0];
                int end_c = points[current_route[j] - 1][1];
                
                while (start_r != end_r) { // 행 다르면 그만큼 행 이동
                    if (start_r < end_r) {
                        start_r++;
                    } else {
                        start_r--;
                    }
                    paths[i].add(new int[]{start_r, start_c});
                }
                
                while (start_c != end_c) { // 열 다르면 그만큼 열 이동
                    if (start_c < end_c) {
                        start_c++;
                    } else {
                        start_c--;
                    }
                    paths[i].add(new int[]{start_r, start_c});
                }
            }            
        }
        
        int max_time = 0;
        for (List<int[]> path : paths) {
            max_time = Math.max(max_time, path.size());
        }
        
        for (int t = 0; t < max_time; t++) {
            int[][] warning_map = new int[101][101];
            
            for (int i = 0; i < paths.length; i++) { // 로봇마다 체크
                if (paths[i].size() <= t) continue;
                
                int[] path = paths[i].get(t);
                int r = path[0];
                int c = path[1];
                
                warning_map[r][c]++;
                
                if (warning_map[r][c] == 2) answer++; // 한번 충돌이 발생할때만 카운트 (중복 제거)
            }
        }
        
        return answer;
    }
}