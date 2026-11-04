import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n][m];
        int maxLength = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 0)  continue;
                
                if (r == 0 || c == 0) {
                    dp[r][c] = 1;
                } else {
                    dp[r][c] = Math.min(
                        dp[r - 1][c],
                        Math.min(dp[r][c - 1], dp[r- 1][c - 1])
                    ) + 1;
                }
                
                maxLength = Math.max(maxLength, dp[r][c]);
            }
        }

        return maxLength * maxLength;
    }
}