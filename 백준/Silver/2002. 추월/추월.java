import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void solution() throws Exception {
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String input_car = br.readLine();
			
			map.put(input_car, i);
		}

		int ans = 0;
		String[] out = new String[N];
		
		for (int i = 0; i < N; i++) {
			out[i] = br.readLine();
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (map.get(out[i]) > map.get(out[j])) {
					ans++;
					break;
				}
			}
		}
		
		
		System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}