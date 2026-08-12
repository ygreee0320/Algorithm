import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // 귤 개수 카운트
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> cnt = new ArrayList<>(map.values());
        cnt.sort(Collections.reverseOrder());
        
        int answer = 0;
        
        // 많은 것부터 담기
        for (int c : cnt) {
            k -= c;
            answer++;
            
            if (k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}