class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        int[] selected = new int[5];
        
        combination(selected, n, q, ans, 1, 0);
        
        return answer;
    }
    
    private void combination(int[] selected, int n, int[][] q, int[] ans, int start, int depth) {
        if (depth == 5) {
            for (int i = 0; i < q.length; i++) {
                int cnt = 0;
                
                for (int j : q[i]) {
                    for (int s : selected) {
                        if (j == s) cnt++;
                    }
                }
                
                if (cnt != ans[i]) {
                    return;
                }
            }
            
            answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            combination(selected, n, q, ans, i + 1, depth + 1);
        }
    }
}