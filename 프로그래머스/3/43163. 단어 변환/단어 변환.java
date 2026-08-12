import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int N = target.length();
        
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{begin, "0"});
        
        while (!q.isEmpty()) {
            String[] next = q.poll();
            String word = next[0];
            String cnt = next[1];
            
            if (word.equals(target)) {
                int result = Integer.parseInt(cnt);
                return result;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                
                int limit = 0;
                
                for (int j = 0; j < N; j++) {
                    char old_c = word.charAt(j);
                    char new_c = words[i].charAt(j);
                    
                    if (old_c != new_c) limit++;
                }
                
                if (limit == 1) {
                    q.add(new String[]{words[i], Integer.toString(Integer.parseInt(cnt) + 1)});
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}