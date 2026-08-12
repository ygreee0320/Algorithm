import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            int num = Integer.parseInt(op[1]);
            
            if (op[0].equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) continue;
                
                int target = 0;
                
                if (op[1].equals("1")) {
                    // 최댓값 제거
                    target = map.lastKey();
                } else {
                    // 최솟값 제거
                    target = map.firstKey();
                }
                
                if (map.get(target) == 1) { // 단어가 하나 존재
                    map.remove(target);
                } else { // 같은 단어 여러개 존재
                    map.put(target, map.get(target) - 1);
                }
            }
       }
        
        if (!map.isEmpty()) {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }      
        
        return answer;
    }
}