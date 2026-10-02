import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // 숫자합 구하기
        long s1 = 0;
        long s2 = 0;
        
        for (int i = 0; i < N; i++) {
            s1 += queue1[i];
            q1.add(queue1[i]);
            s2 += queue2[i];
            q2.add(queue2[i]);
        }
        
        if ((s1 + s2) % 2 != 0) return -1; // 홀수는 불가
        
        // 앞에서부터 하나씩 저울질
        long target = (s1 + s2) / 2;
        long cnt1 = 0;
        long cnt2 = 0;
        
        while ((cnt1 + cnt2) <= (4 * N) && !q1.isEmpty() && !q2.isEmpty()) {
            if (s1 == target) return (int) (cnt1 + cnt2);
            
            if (s1 > target) { // 합이 큰 큐에서 추출
                int num = q1.poll();
                q2.add(num);
                s1 -= num;
                s2 += num;
                cnt1++;
            } else {
                int num = q2.poll();
                q1.add(num);
                s1 += num;
                s2 -= num;
                cnt2++;
            }
        }
        
        return -1;
    }
}