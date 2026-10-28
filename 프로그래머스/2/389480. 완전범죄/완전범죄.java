import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000_000;
        int[] dp = new int[m];
        
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int[] item : info) {
            int a = item[0];
            int b = item[1];
            
            int[] next = new int[m];
            Arrays.fill(next, INF);
            
            for (int i = 0; i < m; i++) {
                if (dp[i] == INF) continue;
                
                int beforeA = dp[i];
                
                if (beforeA + a < n) { // A가 훔치는 경우
                    next[i] = Math.min(next[i], beforeA + a);
                }
                
                if (i + b < m) { // B가 훔치는 경우
                    next[i + b] = Math.min(next[i + b], beforeA);
                }
            }
            
            dp = next;
        }
        
        int answer = INF;
        for (int A : dp) {
            answer = Math.min(answer, A);
        }
        
        if (answer == INF) {
            return -1;
        } else {
            return answer;
        }
    }
}