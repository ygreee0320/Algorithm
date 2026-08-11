import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];
        
        Arrays.fill(clothes, 1);
        
        for (int l : lost) {
            clothes[l]--;
        }
        
        for (int r : reserve) {
            clothes[r]++;
        }
        
        // 번호순으로 왼쪽 학생에게 먼저 빌려주기
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 2) {
                if (clothes[i - 1] == 0) {
                    clothes[i]--;
                    clothes[i - 1]++;
                } else if (clothes[i + 1] == 0) {
                    clothes[i]--;
                    clothes[i + 1]++;
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) answer++;
        }
        
        return answer;
    }
}