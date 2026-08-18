import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        // 첫 10일 반영
        for (int i = 0; i < 10; i++) {
            String target = discount[i];
            
            if (map.containsKey(target)) {
                map.put(target, map.get(target) - 1);
            }
        }
        
        if (isPossible(map)) answer++;
        
        // 가입 시작일을 하루씩 이동
        for (int i = 1; i <= discount.length - 10; i++) {
            String before = discount[i - 1]; // 전날 상품
            String target = discount[i + 9]; // 추가된 상품
            
            if (map.containsKey(before)) {
                map.put(before, map.get(before) + 1);
            }
            
            if (map.containsKey(target)) {
                map.put(target, map.get(target) - 1);
            }
            
            if (isPossible(map)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPossible(Map<String, Integer> map) {
        for (int cnt : map.values()) {
            if (cnt > 0) {
                return false;
            }
        }
        
        return true;
    }
}