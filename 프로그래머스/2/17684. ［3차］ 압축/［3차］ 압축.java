import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), c - 'A' + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        int msg_idx = 0;
        int dict_idx = 27;
        
        while (msg_idx < msg.length()) {
            int start = msg_idx;
            
            while (msg_idx < msg.length()) {
                String target = msg.substring(start, msg_idx + 1);
                
                if (!dict.containsKey(target)) {
                    dict.put(target, dict_idx);
                    dict_idx++;
                    break;
                }
                
                msg_idx++;
            }
            
            result.add(dict.get(msg.substring(start, msg_idx)));
        }
        
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}