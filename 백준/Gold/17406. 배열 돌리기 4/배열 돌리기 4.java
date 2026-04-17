import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	static int N, M, K;
	static int[][] A;
	static int[][] R;
	static int[] pOrder;
	static boolean[] visited;
	static int minResult = 5000;
	
	public void solution() throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		R = new int[K][3];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pOrder = new int[K];
		visited = new boolean[K];
		
		backtracking(0);
		
		System.out.println(minResult);
    }
	
	void backtracking(int depth) {
        if (depth == K) {
            solve();
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pOrder[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    void solve() {
        int[][] tempA = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            tempA[i] = A[i].clone();
        }

        for (int i = 0; i < K; i++) {
            int idx = pOrder[i];
            rotate(R[idx][0], R[idx][1], R[idx][2], tempA);
        }

        calculateMin(tempA);
    }
	
	void rotate(int r, int c, int s, int[][] map) {
		int m_start = c - s;  // 좌우
		int n_start = r - s; // 위아래
		int m_end = c + s;
		int n_end = r + s;
		
		for (int layer = 0; layer < s; layer++) {
	        int ns = n_start + layer;
	        int ne = n_end - layer;
	        int ms = m_start + layer;
	        int me = m_end - layer;

	        int tmp = map[ns][ms];

	        for (int i = ns; i < ne; i++) {
	        	map[i][ms] = map[i + 1][ms];
	        }

	        for (int i = ms; i < me; i++) {
	        	map[ne][i] = map[ne][i + 1];
	        }

	        for (int i = ne; i > ns; i--) {
	        	map[i][me] = map[i - 1][me];
	        }

	        for (int i = me; i > ms; i--) {
	        	map[ns][i] = map[ns][i - 1];
	        }

	        map[ns][ms + 1] = tmp;
	    }
	}
	
	void calculateMin(int[][] map) {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += map[i][j];
            }
            minResult = Math.min(minResult, sum);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}