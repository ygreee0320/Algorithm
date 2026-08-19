import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 5개씩 분할
        List<int[]> sortedMinerals = new ArrayList<>();
        int sum_picks = picks[0] + picks[1] + picks[2];
        int d_cnt = 0; // 다이아 곡괭이 수
        int i_cnt = 0; // 철 곡괭이 수
        int s_cnt = 0; // 돌 곡괭이 수
        
        for (int i = 0; i < minerals.length; i++) {
            if (sortedMinerals.size() == sum_picks) {
                break;
            }
            
            if (minerals[i].equals("diamond")) {
                d_cnt++;
            } else if (minerals[i].equals("iron")) {
                i_cnt++;
            } else {
                s_cnt++;
            }
            
            if ((i + 1) % 5 == 0 || i == minerals.length - 1) {
                sortedMinerals.add(new int[]{d_cnt, i_cnt, s_cnt});
                d_cnt = 0;
                i_cnt = 0;
                s_cnt = 0;
            }
        }
        
        // 정렬 (1. 다이아 개수, 2. 철 개수 내림차순)
        sortedMinerals.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            
           return Integer.compare(b[0], a[0]); 
        });
        
        // 곡괭이 배분
        int answer = 0;
        
        for (int[] mineral : sortedMinerals) {
            if (picks[0] > 0) {
                answer += mineral[0] + mineral[1] + mineral[2];
                picks[0] -= 1;
            } else if (picks[1] > 0) {
                answer += mineral[0] * 5 + mineral[1] + mineral[2];
                picks[1] -= 1;
            } else {
                answer += mineral[0] * 25 + mineral[1] * 5 + mineral[2];
                picks[2] -= 1;
            }
        }
        
        return answer;
    }
}