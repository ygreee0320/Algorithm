import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Map<String, Integer> map = new HashMap<>();
        
        int answer = 0;
        
        int idx = 0; // 스포일러 구간
        String word = "";
        boolean flag = false; // 현재 단어가 스포일러 단어인지
        
        for (int i = 0; i <= message.length(); i++) {
            
            // 이미 끝난 스포일러 구간은 다음 구간으로 이동
            while (idx < spoiler_ranges.length && spoiler_ranges[idx][1] < i) {
                idx++;
            }
            
            // 문자열 끝 또는 단어 처리
            if (i == message.length() || message.charAt(i) == ' ') {
                if (flag) {
                    if (map.getOrDefault(word, -1) == -1) {
                        answer++;
                        map.put(word, 1);
                    }
                } else {
                    if (map.getOrDefault(word, -1) == 1) {
                        answer--;
                    }
                    
                    map.put(word, 0);
                }
                
                word = "";
                flag = false;
            } else {
                // 현재 문자가 스포 구간에 포함되면
                if (idx < spoiler_ranges.length && spoiler_ranges[idx][0] <= i && i <= spoiler_ranges[idx][1]) {
                    flag = true;
                }
                
                word += message.charAt(i);
            }
        }
        
        return answer;
    }
}