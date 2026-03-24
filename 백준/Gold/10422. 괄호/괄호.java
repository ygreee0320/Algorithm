import java.io.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	long[] dp = new long[5001];
	
	public void solution() throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		start_dp();
		
		for (int t = 0; t < T; t++) {
			int L = Integer.parseInt(br.readLine());
			
			System.out.println(dp[L]);
		}
    }
	
	public void start_dp() {
		dp[0] = dp[2] = 1;
		
		for (int i = 4; i <= 5000; i += 2) {
			for (int j = 0; j < i; j += 2) {
				dp[i] += dp[j] * dp[i - j - 2];
				dp[i] %= 1000000007;
			}
		}
	}

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}