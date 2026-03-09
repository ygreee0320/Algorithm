import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switch_num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = switch_num; j <= n; j += switch_num) {
                    if (arr[j] == 1) {
                        arr[j] = 0;
                    } else {
                        arr[j] = 1;
                    }
                }
            } else {
                if (arr[switch_num] == 1) {
                    arr[switch_num] = 0;
                } else {
                    arr[switch_num] = 1;
                }

                for (int j = 1; j + switch_num <= n; j++) {
                    if (switch_num - j == 0) {
                        break;
                    }

                    if (arr[switch_num + j] == arr[switch_num - j]) {
                        if (arr[switch_num + j] == 1) {
                            arr[switch_num + j] = 0;
                            arr[switch_num - j] = 0;
                        } else {
                            arr[switch_num + j] = 1;
                            arr[switch_num - j] = 1;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}