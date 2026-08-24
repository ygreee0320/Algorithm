class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d_idx = n - 1;
        int p_idx = n - 1;
        
        while (d_idx >= 0 || p_idx >= 0) {
            
            // 물량이 없는 집 건너 뛰기
            while (d_idx >= 0 && deliveries[d_idx] == 0) {
                d_idx--;
            }
            
            while (p_idx >= 0 && pickups[p_idx] == 0) {
                p_idx--;
            }
            
            // 모두 처리한 경우 종료
            if (d_idx < 0 && p_idx < 0) {
                break;
            }
            
            // 물량을 처리하기 전에 먼 위치로 거리 계산
            answer += (long) (Math.max(d_idx, p_idx) + 1) * 2;
            
            // 배달
            int current = 0; // 싣고있는 상자
            
            while (d_idx >= 0 && current < cap) {
                int limit = cap - current;
                
                if (deliveries[d_idx] > limit) {
                    current += limit;
                    deliveries[d_idx] -= limit;
                } else {
                    current += deliveries[d_idx];
                    deliveries[d_idx] = 0;
                    d_idx--;
                }
            }
            
            // 수거
            current = 0;
            
            while (p_idx >= 0 && current < cap) {
                int limit = cap - current;
                
                if (pickups[p_idx] > limit) {
                    current += limit;
                    pickups[p_idx] -= limit;
                } else {
                    current += pickups[p_idx];
                    pickups[p_idx] = 0;
                    p_idx--;
                }
            }
        }
        
        return answer;
    }
}