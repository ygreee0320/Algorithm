import java.util.*;

class Solution {
    int[] answer = new int[11];
    int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        combination(n, info, 0, new int[11]);
        
        if (maxDiff == 0) return new int[]{-1};
        
        return answer;
    }
    
    private void combination(int n, int[] info, int start, int[] lion) {
        if (n == 0) {
            int sumA = 0;
            int sumL = 0;
            
            for (int i = 0; i < info.length; i++) {
                if (lion[i] > info[i]) {
                    sumL += 10 - i;
                } else if (info[i] > 0) {
                    sumA += 10 - i;
                }
            }
            
            if (sumL > sumA) {
                int diff = sumL - sumA;
                
                if (diff > maxDiff || diff == maxDiff && isLower(lion)) {
                    answer = Arrays.copyOf(lion, 11);
                    maxDiff = sumL - sumA;
                }
            }
        }
        
        for (int i = start; i < 11; i++) {
            int cnt = 0;
            if (i == info.length - 1) {
                cnt = n;
            } else {
                cnt = info[i] + 1;
            }
            
            if (n < cnt) continue;
            
            lion[i] = cnt;
            combination(n - cnt, info, i + 1, lion);
            lion[i] = 0;
        }
    }
    
    private boolean isLower(int[] lion) {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] != answer[i]) {
                return lion[i] > answer[i];
            }
        }
        
        return false;
    }
}