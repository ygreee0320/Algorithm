import java.io.*;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, k;
    int[] coins, dp;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int currentCoin = coins[i];

            for (int j = currentCoin; j <= k; j++) {
                dp[j] = dp[j] + dp[j - currentCoin];
            }
        }

        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}