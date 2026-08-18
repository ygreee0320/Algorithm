import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            String target = discount[i];
            
            if (map.containsKey(target)) {
                map.put(target, map.get(target) - 1);
            }
            
            boolean possible = true;
            
            for (int cnt : map.values()) {
                if (cnt > 0) possible = false;
            }
            
            if (possible) answer++;
        }
        
        for (int i = 1; i <= discount.length - 10; i++) {
            String before = discount[i - 1];
            String target = discount[i + 9];
            
            if (map.containsKey(before)) {
                map.put(before, map.get(before) + 1);
            }
            
            if (map.containsKey(target)) {
                map.put(target, map.get(target) - 1);
            }
            
            boolean possible = true;
            
            for (int cnt : map.values()) {
                if (cnt > 0) possible = false;
            }
            
            if (possible) answer++;
        }
        
        return answer;
    }
}