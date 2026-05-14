import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[][] map = new int[n][n];
            int r = 1; // 숫자

            sb.append('#').append(test_case).append('\n');

            for (int k = 0; k < n - 1; k++) {
                int start = k;
                int end = n - k - 1;

                for (int j = start; j < end; j++) {
                    map[k][j] = r;
                    r++;
                }

                for (int j = start; j < end; j++) {
                    map[j][end] = r;
                    r++;
                }

                for (int j = end; j > k; j--) {
                    map[end][j] = r;
                    r++;
                }

                for (int j = end; j > k; j--) {
                    map[j][k] = r;
                    r++;
                }
            }

            if (n % 2 == 1) {
                map[n / 2][n / 2] = r;
            }

            for (int[] m : map) {
                for (int j : m) {
                    sb.append(j).append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
	}
}