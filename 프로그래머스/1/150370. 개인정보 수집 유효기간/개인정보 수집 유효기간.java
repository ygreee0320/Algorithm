import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }
        
        String[] todays = today.split("\\.");
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String startDay = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];
            
            int year = Integer.parseInt(startDay.split("\\.")[0]);
            int month = Integer.parseInt(startDay.split("\\.")[1]);
            int day = Integer.parseInt(startDay.split("\\.")[2]);
            
            int typeMonth = termMap.get(type);
            
            month += typeMonth;
            
            if (month > 12) {
                int y = month / 12;
                
                if (month % 12 == 0) {
                    year += y - 1;
                    month = 12;
                } else {
                    year += y;
                    month %= 12;
                }
            }
            
            // 오늘 날짜와 비교
            if (Integer.parseInt(todays[0]) > year) {
                answer.add(i + 1);
            } else if (Integer.parseInt(todays[0]) == year) {
                if (Integer.parseInt(todays[1]) > month) {
                    answer.add(i + 1);
                } else if (Integer.parseInt(todays[1]) == month) {
                    if (Integer.parseInt(todays[2]) >= day) {
                        answer.add(i + 1);
                    }
                }
            }
        }
        
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}