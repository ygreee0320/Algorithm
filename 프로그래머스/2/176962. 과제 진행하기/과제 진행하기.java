import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        
        // 시작 시간순 정렬
        Arrays.sort(plans, (a, b) -> {
            int a_start = transferM(a[1]);
            int b_start = transferM(b[1]);
            
            return Integer.compare(a_start, b_start);
        });
        
        int idx = 0;
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                answer[idx] = plans[i][0];
                idx++;
                
                while (!stack.empty()) {
                    int[] next = stack.pop();
                    answer[idx] = plans[next[0]][0];
                    idx++;
                }
                
                break;
            }
            
            int endTime = transferTotal(plans[i][1], plans[i][2]);
            int nextStart = transferM(plans[i + 1][1]);
            
            if (endTime <= nextStart) {
                answer[idx] = plans[i][0];
                idx++;
                
                // 일찍 끝나면 스택 확인
                while (!stack.empty() && endTime < nextStart) {
                    int[] next = stack.pop();
                    endTime += next[1];
                    
                    if (endTime <= nextStart) {
                        answer[idx] = plans[next[0]][0];
                        idx++;
                    } else {
                        stack.push(new int[]{next[0], endTime - nextStart});
                        break;
                    }
                }
            } else { // 다 못하면 스택으로
                int remain = endTime - nextStart;
                stack.push(new int[]{i, remain});
            }
        }
        
        return answer;
    }
    
    private int transferM(String start) {
        String[] starts = start.split(":");
        
        return Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
    }
    
    private int transferTotal(String start, String end) {
        return transferM(start) + Integer.parseInt(end);
    }
}