import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        
        Map<String, Integer> map_p = new HashMap<>(); // 플레이어 기준
        Map<Integer, String> map_r = new HashMap<>(); // 랭킹 기준
        
        for (int i = 0; i < n; i++) {
            map_p.put(players[i], i);
            map_r.put(i, players[i]);
        }
        
        for (String runner : callings) {
            int current = map_p.get(runner);
            String front_runner = map_r.get(current - 1);
            
            map_p.put(runner, current - 1);
            map_p.put(front_runner, current);
            
            map_r.put(current, front_runner);
            map_r.put(current - 1, runner);
        }
        
        String[] result = new String[n];
        
        for (Map.Entry<Integer, String> entry : map_r.entrySet()) {
            result[entry.getKey()] = entry.getValue();
        }
        
        return result;
    }
}