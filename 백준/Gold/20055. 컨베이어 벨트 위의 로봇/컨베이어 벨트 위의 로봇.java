import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	public void solution() throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] convey = new int[N * 2];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < convey.length; i++) {
			convey[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		int cnt = 0;
		int pointer = 0;
		List<Integer> robot = new ArrayList<>();
		
		while (true) {
			// 1
			res++;
			pointer--;
			if (pointer < 0) pointer = convey.length - 1;
			
			for (int i = 0; i < robot.size(); i++) {
				robot.set(i, robot.get(i) + 1);
			}
			
			for (int i = robot.size() - 1; i >= 0; i--) {
				if (robot.get(i) >= (N - 1)) {
					robot.remove(i);
				}
			}
			
			// 2
			for (int i = 0; i < robot.size(); i++) {
				int next = robot.get(i) + 1;
				
				if (i > 0 && robot.get(i - 1) == next) {
					continue;
				}
				
				int next_pointer = pointer + next;
				if (next_pointer > convey.length - 1) next_pointer -= convey.length;
				
				if (convey[next_pointer] == 0) {
					continue;
				}
				
				robot.set(i, next);
				convey[next_pointer]--;
				if (convey[next_pointer] == 0) cnt++;
			}
			
			for (int i = robot.size() - 1; i >= 0; i--) {
				if (robot.get(i) >= (N - 1)) {
					robot.remove(i);
				}
			}
			
			// 3
			if (convey[pointer] != 0) {
				robot.add(0);
				convey[pointer]--;
				
				if (convey[pointer] == 0) cnt++;
			}
			
			// 4
			if (cnt >= K) break;
		}
		
		System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}