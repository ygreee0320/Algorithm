import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    isValid = false;
                    break;
                }
                
                stack.pop();
            }
        }
        
        if (isValid && stack.isEmpty()) {
            answer = true;
        }

        return answer;
    }
}