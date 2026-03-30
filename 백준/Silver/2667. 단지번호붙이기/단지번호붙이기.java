import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    int[][] map;
    boolean[][] visited;

    void solution() throws Exception {
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int group_num = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    res.add(bfs(i, j, N, group_num));
                }
            }
        }

        sb.append(res.size()).append("\n");

        Collections.sort(res);

        for (int size : res) {
            sb.append(size).append("\n");
        }

        System.out.println(sb);
    }

    int bfs(int startX, int startY, int N, int g) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        cnt++;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}