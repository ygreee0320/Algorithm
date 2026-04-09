import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] solved1 = {1, 2, 3, 4, 5};
        int[] solved2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] solved3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};
        
        int[] cnt = new int[3];
        int max_cnt = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int r1 = solved1[i % solved1.length];
            int r2 = solved2[i % solved2.length];
            int r3 = solved3[i % solved3.length];
            
            if (r1 == answers[i]) cnt[0]++;
            if (r2 == answers[i]) cnt[1]++;
            if (r3 == answers[i]) cnt[2]++;
            
            max_cnt = Math.max(max_cnt, cnt[0]);
            max_cnt = Math.max(max_cnt, cnt[1]);
            max_cnt = Math.max(max_cnt, cnt[2]);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max_cnt) {
                res.add(i + 1);
            }
        }
        
        int[] answer = new int[res.size()];
        
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}