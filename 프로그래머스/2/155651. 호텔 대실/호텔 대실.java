import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] book_min = new int[n][2];
        
        // 분 단위로 치환
        for (int i = 0; i < n; i++) {
            String start_h = book_time[i][0].split(":")[0];
            String start_m = book_time[i][0].split(":")[1];
            String end_h = book_time[i][1].split(":")[0];
            String end_m = book_time[i][1].split(":")[1];
            
            book_min[i][0] = Integer.parseInt(start_h) * 60 + Integer.parseInt(start_m);
            book_min[i][1] = Integer.parseInt(end_h) * 60 + Integer.parseInt(end_m) + 10;
        }
        
        // 시작 시간 기준 정렬
        Arrays.sort(book_min, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 배정
        int[] room = new int[n];
        int max_room = 1;
        
        for (int i = 0; i < n; i++) {
            if (max_room >= n) break;
            
            boolean flag = true; // 새로운 방 필요 여부
            
            for (int j = 0; j < max_room; j++) {
                if (room[j] <= book_min[i][0]) {
                    room[j] = book_min[i][1]; // 기존 방 배정
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                room[max_room] = book_min[i][1];
                max_room++;
            }
        }
        
        return max_room;
    }
}