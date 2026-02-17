import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    Stack<Character> stack = new Stack<>();
    int res = 0;

    void solution() throws Exception {
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(') {
                stack.push(current);
            } else {
                stack.pop();

                if (input.charAt(i - 1) == '(') {
                    res += stack.size();
                } else {
                    res += 1;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}