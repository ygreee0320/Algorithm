import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        sb.append("<");

        int idx = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;

            while (true) {
                if (arr[idx] > 0) {
                    cnt++;
                }

                if (cnt == K) {
                    sb.append(arr[idx]);
                    arr[idx] = -1;
                    idx = (idx + 1) % N;

                    if (i < N - 1) {
                        sb.append(", ");
                    } else {
                        sb.append(">");
                    }
                    break;
                }

                idx = (idx + 1) % N;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}