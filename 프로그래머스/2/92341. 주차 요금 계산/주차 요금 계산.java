import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 입차 시간 기록 (차량번호 - 입차시간)
        Map<String, Integer> inTimeMap = new HashMap<>(); 
        // 누적 시간 기록 (차량번호 - 입차시간)
        Map<String, Integer> totalTimeMap = new TreeMap<>(); 
        
        for(String record: records) {
            String[] split_record = record.split(" ");
            String[] timeStr = split_record[0].split(":");
            int time = 60 * Integer.parseInt(timeStr[0]) + Integer.parseInt(timeStr[1]);
            String num = split_record[1];
            String inOut = split_record[2];
            
            if (inOut.equals("IN")) {
                inTimeMap.put(num, time);
            } else {
                int inTime = inTimeMap.remove(num);
                int parkedTime = time - inTime;
                totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + parkedTime);
            }
        }
        
        // 출차 기록 없는 차량 정리 (23:59 처리)
        int endOfDay = 23 * 60 + 59;
        for (String num : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(num);
            int parkedTime = endOfDay - inTime;
            totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + parkedTime);
        }
        
        int[] answer = new int[totalTimeMap.size()];
        int idx = 0;
        
        for (int totalTime : totalTimeMap.values()) {
            if (totalTime <= basicTime) {
                answer[idx] = basicFee;
            } else {
                int extraTime = totalTime - basicTime;
                answer[idx] = basicFee + (int) Math.ceil((double) extraTime / unitTime) * unitFee;
            }
            
            idx++;
        }
        
        return answer;
    }
}