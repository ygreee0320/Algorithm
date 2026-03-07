import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plums = new int[1001];
        plums[0] = 1;

        for (int i = 1; i <= T; i++) {
            plums[i] = Integer.parseInt(br.readLine());
        }

        int dp[][][] = new int[T+1][W+1][3]; //현재 초, 그동안 몇번 이동, 현위치

        if (plums[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int t = 2; t <= T; t++) {

            if (plums[t] == 1) { // 1번에서 자두 떨어짐
                dp[t][0][1] = dp[t-1][0][1] + 1;
                dp[t][0][2] = dp[t-1][0][2];

                for (int w = 1; w <= W; w++) {
                    dp[t][w][1] = Math.max(dp[t-1][w][1], dp[t-1][w-1][2]) + 1;
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1], dp[t-1][w][2]);
                }
            }

            else { // 2번에서 자두 떨어짐
                dp[t][0][1] = dp[t-1][0][1];
                dp[t][0][2] = dp[t-1][0][2] + 1;

                for (int w = 1; w <= W; w++) {
                    dp[t][w][1] = Math.max(dp[t-1][w][1], dp[t-1][w-1][2]);
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1], dp[t-1][w][2]) + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= W; i++) {
            res = Math.max(res, Math.max(dp[T][i][1], dp[T][i][2]));
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}