import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void solution() throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int L = Integer.parseInt(br.readLine());
			
			if (L == 1) {
				System.out.println("0");
				continue;
			}
			
			long[] dp = new long[L + 1];
			dp[0] = dp[2] = 1;
			
			for (int i = 4; i <= L; i += 2) {
				for (int j = 0; j < i; j += 2) {
					dp[i] += dp[j] * dp[i - j - 2];
					dp[i] %= 1000000007;
				}
			}
			
			System.out.println(dp[L]);
		}
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}