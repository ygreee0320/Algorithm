import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());
        int res;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer> A = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> B = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            A.sort(Collections.reverseOrder());
            B.sort(Collections.reverseOrder());

            res = 0;
            int pointer = 0;

            for (int b : B) {
                res += pointer;

                for (int j = pointer; j < n; j++) {
                    if (A.get(j) > b) {
                        res += 1;
                        pointer += 1;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(res);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}