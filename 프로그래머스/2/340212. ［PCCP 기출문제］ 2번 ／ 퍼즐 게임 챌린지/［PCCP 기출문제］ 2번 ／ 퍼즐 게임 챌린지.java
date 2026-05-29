class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = 100000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            long t = times[0];
            for (int i = 1; i < diffs.length; i++) {
                t += solve(diffs[i], mid, times[i], times[i - 1]);
            }
            
            if (t <= limit) {
                answer = mid; // 정답 후보
                right = mid - 1; // 더 낮은 레벨 가능한지 탐색
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public long solve(int diff, int level, int time_cur, int time_prev) {
        if (level >= diff) return time_cur;
        else {
            int error_cnt = diff - level;
            long t = error_cnt * (time_cur + time_prev) + time_cur;
            return t;
        }
    }
}