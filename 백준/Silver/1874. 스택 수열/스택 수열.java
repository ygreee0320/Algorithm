import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    int n, current;

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        current = 1;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            while (k >= current) {
                stack.push(current);
                sb.append("+").append("\n");
                current++;
            }

            if (stack.peek() == k) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}