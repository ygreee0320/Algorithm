import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int num = 1;
        int answer = 0;
        
        for (int i : order) {
            if (i == num) {
                answer++;
                num++;
            } else if (i > num) {
                while (num < i) {
                    sub.push(num);
                    num++;
                }
                
                answer++;
                num++;
            } else {
                boolean flag = false;
                
                if (!sub.isEmpty()) {
                    int next = sub.pop();
                    
                    if (next == i) {
                        answer++;
                        flag = true;
                    }
                }
                
                if (!flag) {
                    break;
                }
            }
        }
        
        return answer;
    }
}