import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = gems.length;
        
        // 모든 보석
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        
        // 보석별 개수
        Map<String, Integer> map = new HashMap<>();
        for (String s : set) {
            map.put(s, 0);
        }
        
        int left = 0;
        int right = 0;
        int count = 1;
        int len = 100001;
        map.put(gems[0], 1);
        
        while (left <= right && left < n && right < n) {
            if (count == map.size()) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                
                if (map.get(gems[left]) == 1) {
                    count--;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }
            
            if (count < map.size()) {
                right++;
                
                if (right >= n) break;
                
                if (map.get(gems[right]) == 0) {
                    count++;
                }
                
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            }
        }
        
        return answer;
    }
}