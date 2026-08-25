import java.util.*;

class Solution {
    String[] answer;
    int n;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        answer = new String[n + 1];
        
        // 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            
            return a[0].compareTo(b[0]);
        });
        
        // 출발지 저장
        List<String[]> starts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (tickets[i][0].equals("ICN")) {
                String[] start = {tickets[i][0], tickets[i][1], Integer.toString(i)};
                starts.add(start);
            }
        }
        
        // 출발지부터 dfs
        visited = new boolean[n];
        
        for (String[] start : starts) {
            String[][] travel = new String[n][2];
            travel[0][0] = start[0];
            travel[0][1] = start[1];
            int idx = Integer.parseInt(start[2]);
            
            visited[idx] = true;
            
            boolean isPossible = dfs(tickets, travel, 0);
            
            if (isPossible) {
                break;
            }
            
            visited[idx] = false;
        }
        
        return answer;
    }
    
    private boolean dfs(String[][] tickets, String[][] travel, int idx) {
        if (idx == n - 1) {
            for (int i = 0; i < n; i++) {
                answer[i] = travel[i][0];
            }
            
            answer[n] = travel[n - 1][1];
            
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && travel[idx][1].equals(tickets[i][0])) {
                travel[idx + 1][0] = tickets[i][0];
                travel[idx + 1][1] = tickets[i][1];
                visited[i] = true;
                
                if (dfs(tickets, travel, idx + 1)) {
                    return true;
                }
                
                visited[i] = false;
            }
        }
        
        return false;
    }
}