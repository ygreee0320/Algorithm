import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();

    void solution() throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long totalProfit = 0;
            int maxPrice = 0;

            // 뒤에서부터 탐색
            for (int j = N - 1; j >= 0; j--) {
                if (arr[j] > maxPrice) {
                    // 현재 주가가 최고가보다 높으면 최고가 갱신
                    maxPrice = arr[j];
                } else {
                    // 현재 주가가 최고가보다 낮으면 그 차액만큼 수익 발생
                    totalProfit += (maxPrice - arr[j]);
                }
            }
            sb.append(totalProfit).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}