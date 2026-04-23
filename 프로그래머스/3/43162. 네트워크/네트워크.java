class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int c, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[i][c] == 1) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}