import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for (String runner : callings) {
            int current = rank.get(runner);
            String frontRunner = players[current - 1];
            
            players[current - 1] = runner;
            players[current] = frontRunner;
            
            rank.put(runner, current - 1);
            rank.put(frontRunner, current);
        }
        
        return players;
    }
}