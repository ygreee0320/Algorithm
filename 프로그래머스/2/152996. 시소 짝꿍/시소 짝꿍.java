import java.util.*;

class Solution {
    public long solution(int[] weights) {
        int[] count = new int[1001];
        long answer = 0;
        
        for (int w : weights) {
            count[w] += 1;
        }
        
        for (int w = 100; w < count.length; w++) {
            if (count[w] == 0) continue;
            
            if (count[w] > 1) {
                answer += (long) count[w] * (count[w] - 1) / 2;
            }
            
            if ((w * 4) % 3 == 0) {
                int other = w * 4 / 3;
                
                if (other < count.length) {
                    answer += (long) count[w] * count[other];
                }
            }
            
            if (w * 2 < count.length) {
                answer += (long) count[w] * count[w * 2];
            }
            
            if ((w * 3) % 2 == 0) {
                int other = w * 3 / 2;
                
                if (other < count.length) {
                    answer += (long) count[w] * count[other];
                }
            }
        }
        
        return answer;
    }
}