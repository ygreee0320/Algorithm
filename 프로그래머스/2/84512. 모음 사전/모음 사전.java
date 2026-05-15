import java.util.*;

class Solution {
    char[] book = {'A', 'E', 'I', 'O', 'U'};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        
        return list.indexOf(word);
    }
    
    public void dfs(String word) {
        if (word.length() > 5) {
            return;
        }
        
        list.add(word);
        
        for(char v : book) {
            dfs(word + v);
        }
    }
}