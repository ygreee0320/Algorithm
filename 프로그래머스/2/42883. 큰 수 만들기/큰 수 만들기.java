import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++) {
            int target = Integer.parseInt(number.substring(i, i + 1));
            
            if (k == 0 || stack.isEmpty()) {
                stack.push(target);
                continue;
            }
            
            while (!stack.isEmpty() && k > 0) {
                if (target > stack.peek()) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            
            stack.push(target);
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        for (int s : stack) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}