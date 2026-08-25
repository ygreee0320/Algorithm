import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int n = targets.length;
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int point = -1; // 요격 지점
        
        for (int[] target : targets) {
            if (target[0] >= point) {
                answer++;
                point = target[1];
            }
        }
        
        return answer;
    }
}