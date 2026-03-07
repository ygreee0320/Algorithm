import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, M, r, c, d;
    int res = 1;
    int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    int[] dy = {0, 1, 0, -1};
    boolean flag;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int currentR = r;
        int currentC = c;
        int currentD = d;

        room[currentR][currentC] = -1;

        while (true) {
            if (currentR < 0 || currentC < 0 || currentR >= N || currentC >= M || room[currentR][currentC] == 1) {
                break;
            }

            flag = false;

            for (int i = 0; i < 4; i++) {
                currentD = (currentD + 3) % 4;
                int nR = currentR + dx[currentD];
                int nC = currentC + dy[currentD];

                if (nR >= 0 && nC >= 0 && nR < N && nC < M) {
                    if (room[nR][nC] == 0) {
                        currentR = nR;
                        currentC = nC;

                        room[currentR][currentC] = -1;
                        res++;
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                int bD = (currentD + 2) % 4; // 후진할 방향
                currentR = currentR + dx[bD];
                currentC = currentC + dy[bD];
            }
        }

        System.out.println(res);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}