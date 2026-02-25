import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, Integer> distance = new HashMap<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);
        distance.put(X, 0);

        while (!q.isEmpty()) {
            int p = q.poll();
            int beforeD = distance.get(p);

            for (int next : graph.get(p)) {
                if (!distance.containsKey(next)) {
                    distance.put(next, beforeD + 1);
                    q.offer(next);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int key : distance.keySet()) {
            if (distance.get(key) == K) {
                res.add(key);
            }
        }

        if (res.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(res);
            for (int r : res) {
                System.out.println(r);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}