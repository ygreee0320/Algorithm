import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 정렬
        Arrays.sort(people);
        
        // 뒤부터 맨 앞 확인
        int answer = 0;
        int idx = 0;
        
        for (int i = people.length - 1; i >= 0; i--) {
            if (i == idx) {
                answer++;
                break;
            } else if (i < idx) break;
            
            int l = limit - people[i];
            
            if (l - people[idx] >= 0) {
                idx++;
            }
            
            answer++;
        }
        
        return answer;
    }
}