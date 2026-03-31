import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] parent;
    int[] truthPeople;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

         truthPeople = new int[T];
        for (int i = 0; i < T; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<int[]> party = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int[] members = new int[C];

            for (int j = 0; j < C; j++) {
                members[j] = Integer.parseInt(st.nextToken());
            }
            party.add(members);

            for (int j = 0; j < C - 1; j++) {
                union(members[j], members[j + 1]);
            }
        }

        int res = 0;
        for (int[] p : party) {
            boolean canLie = true;
            for (int member : p) {
                if (isConnect(member, truthPeople)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) res++;
        }

        System.out.println(res);
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[b] = a;
    }

    boolean isConnect(int member, int[] truthPeople) {
        int root = find(member);
        for (int t : truthPeople) {
            if (root == find(t)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}