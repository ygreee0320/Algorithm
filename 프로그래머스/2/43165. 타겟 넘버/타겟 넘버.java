class Solution {
    int answer = 0;
    int t;
    
    public int solution(int[] numbers, int target) {
        t = target;
        
        dfs(numbers, 0, 0);
        
        return answer;
    }
    
    void dfs(int[] numbers, int cnt_num, int depth) {
        if (depth == numbers.length) {
            if (cnt_num == t) answer++;
            return;
        }
        
        dfs(numbers, cnt_num + numbers[depth], depth + 1);
        dfs(numbers, cnt_num - numbers[depth], depth + 1);
    }
}