import java.util.*;

class Solution {
    private Set<String> resultSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        resultSet = new HashSet<>();
        boolean[] visited = new boolean[user_id.length];
        
        dfs(0, visited, user_id, banned_id);
        
        return resultSet.size();
    }
    
    private void dfs(int banIdx, boolean[] visited, String[] user_id, String[] banned_id) {
        if (banIdx == banned_id.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    temp.add(user_id[i]);
                }
            }
            
            Collections.sort(temp);
            
            resultSet.add(temp.toString());
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && isMatch(user_id[i], banned_id[banIdx])) {
                visited[i] = true;
                dfs(banIdx + 1, visited, user_id, banned_id);
                visited[i] = false;
            }
        }
    }
    
    private boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) {
            return false;
        }
        
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}