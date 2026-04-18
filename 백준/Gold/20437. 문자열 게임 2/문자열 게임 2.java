import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb;
    public static final int MAX_VALUE = 10001;

    void solution() throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            List<Integer>[] alpha = new ArrayList[26]; // 알파벳별로 인덱스 저장
            for (int j = 0; j < 26; j++) {
                alpha[j] = new ArrayList<>();
            }

            for (int j = 0; j < W.length(); j++) {
                alpha[W.charAt(j) - 'a'].add(j);
            }

            int min_res = MAX_VALUE;
            int max_res = -1;

            for (int j = 0; j < alpha.length; j++) {
                if (alpha[j].size() >= K) {
                    for (int k = 0; k <= alpha[j].size() - K; k++) {
                        // 길이 : (끝 인덱스 - 시작 인덱스 + 1)
                        int currentLen = alpha[j].get(k + K - 1) - alpha[j].get(k) + 1;

                        min_res = Math.min(min_res, currentLen);
                        max_res = Math.max(max_res, currentLen);
                    }
                }
            }

            sb = new StringBuilder();

            if (min_res == MAX_VALUE) {
                sb.append(-1);
            } else {
                sb.append(min_res).append(" ").append(max_res);
            }

            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}