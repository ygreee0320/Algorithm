import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
        
        Map<Integer, Integer> toppingA = new HashMap<>();
        Map<Integer, Integer> toppingB = new HashMap<>();
        
        int answer = 0;
        int slice = 0; // 자를 기준
        
        toppingA.put(topping[0], 1);
        
        for (int i = 1; i < n; i++) {
            toppingB.put(topping[i], toppingB.getOrDefault(topping[i], 0) + 1);
        }
        
        if (toppingA.size() == toppingB.size()) {
            answer++;
        }
        
        while (slice < n - 1) {
            slice++;
            int target = topping[slice];
            
            toppingA.put(target, toppingA.getOrDefault(target, 0) + 1);
            
            if (toppingB.get(target) == 1) {
                toppingB.remove(target);
            } else {
                toppingB.put(target, toppingB.get(target) - 1);
            }
            
            if (toppingA.size() == toppingB.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}