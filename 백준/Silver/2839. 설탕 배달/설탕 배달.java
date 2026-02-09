import java.io.*;
import java.util.Arrays;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    int[] dp;
    int MAX = 9999;

    void solution() throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        Arrays.fill(dp, MAX);

        dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        System.out.println(dp[N] >= MAX ? -1 : dp[N]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
