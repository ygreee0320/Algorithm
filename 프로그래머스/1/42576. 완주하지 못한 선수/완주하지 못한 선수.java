import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (String p : participant) {
            int isComplete = map.getOrDefault(p, 0);
            
            if (isComplete == 0) {
                answer = p;
                break;
            } else {
                map.put(p, map.get(p) - 1);
            }
        }
        
        return answer;
    }
}