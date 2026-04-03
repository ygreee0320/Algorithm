import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> res = new ArrayList<>();
        
        if (arr.length == 0) {
            int[] answer = new int[0];
            return answer;
        }
        
        res.add(arr[0]);
        int before_idx = 0;
    
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == res.get(before_idx)) continue;
            
            res.add(arr[i]);
            before_idx++;
        }
        
        int[] answer = new int[before_idx + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}