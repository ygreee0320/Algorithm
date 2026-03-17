import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	public void solution() throws Exception {
		String str = br.readLine();

		StringBuilder sb = new StringBuilder();
		StringBuilder word = new StringBuilder();
		
		boolean flag = false;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '<') {
				if (word.length() > 0) {
					sb.append(word.reverse());
					word.setLength(0);
				}
				flag = true;
				sb.append(c);
			} else if (c == '>') {
				flag = false;
				sb.append(c);
			} else if (flag) {
				sb.append(c);
			} else {
				if (c == ' ') {
					sb.append(word.reverse());
					sb.append(c);
					word.setLength(0);
				} else {
					word.append(c);
				}
			}
		}
		

		if (word.length() > 0) {
			sb.append(word.reverse());
		}
		
		System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}