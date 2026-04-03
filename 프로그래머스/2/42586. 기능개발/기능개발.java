import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> works = new ArrayList<>();
        
        int before_deploy = 0;
        for (int i = 0; i < progresses.length; i++) {
            int current_deploy = (100 - progresses[i]) / speeds[i];
            int rest = (100 - progresses[i]) % speeds[i];
            
            if (rest != 0) current_deploy++;
            
            if (current_deploy > before_deploy) {
                works.add(1);
                before_deploy = current_deploy;
            } else {
                int n = works.size() - 1;
                works.set(n, works.get(n) + 1);
            }
        }
        
        int[] answer = new int[works.size()];
        
        for (int i = 0; i < works.size(); i++) {
            answer[i] = works.get(i);
        }
        
        return answer;
    }
}