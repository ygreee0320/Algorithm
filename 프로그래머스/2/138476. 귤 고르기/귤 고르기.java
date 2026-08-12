import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] cnt = new int[10000001];
        int answer = 0;
        
        // 귤 개수 카운트
        for (int t : tangerine) {
            cnt[t] += 1;
        }
        
        // 개수 정렬 (내림차순)
        Arrays.sort(cnt);
        
        for (int i = 0; i < cnt.length / 2; i++) {
            int temp = cnt[i];
            cnt[i] = cnt[cnt.length - 1 - i];
            cnt[cnt.length - 1 - i] = temp;
        }
        
        // 많은 것부터 담기
        for (int i = 0; i < cnt.length; i++) {
            if (k > cnt[i]) {
                k -= cnt[i];
                answer++;
            } else {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}