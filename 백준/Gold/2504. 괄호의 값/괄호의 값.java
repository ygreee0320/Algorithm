import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    Stack<Character> stack = new Stack<>();
    int res = 0;

    void solution() throws Exception {
       input = br.readLine();
       int multiplier = 1;
       boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(') {
                stack.push(current);
                multiplier *= 2;
            } else if (current == '[') {
                stack.push(current);
                multiplier *= 3;
            } else if (current == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    isValid = false;
                    break;
                }
                
                if (input.charAt(i - 1) == '(') {
                    res += multiplier;
                }
                
                stack.pop();
                multiplier /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    isValid = false;
                    break;
                }
                
                if (input.charAt(i - 1) == '[') {
                    res += multiplier;
                }
                
                stack.pop();
                multiplier /= 3;
            }
        }
        
        if (isValid && stack.isEmpty()) {
            System.out.println(res);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}