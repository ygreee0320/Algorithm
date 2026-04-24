class Solution {
    int[] n2;
    
    public int solution(int n) {
        int n_cnt = countBits(n);
        int answer = n + 1;
        
        while (true) {
            if (countBits(answer) == n_cnt) {
                return answer;
            }
            answer++;
        }
    }
    
    int countBits(int n) {
        int cnt = 0;
        
        while (n > 0) {
            if (n % 2 == 1) cnt++;
            n /= 2;
        }
        
        return cnt;
    }
}