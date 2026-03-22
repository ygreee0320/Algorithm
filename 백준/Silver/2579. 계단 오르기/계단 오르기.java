import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}