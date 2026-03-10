import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int ans = 1;

            for (String key : map.keySet()) {
                ans *= (map.get(key) + 1);
            }

            System.out.println(ans - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}