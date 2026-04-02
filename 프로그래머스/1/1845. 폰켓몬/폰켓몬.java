import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int select_cnt = nums.length / 2;
        int answer = 0;
        
        for (int key : map.keySet()) {
            if (map.get(key) > 0 && answer < select_cnt) {
                answer++;
            }
        }
        
        return answer;
    }
}