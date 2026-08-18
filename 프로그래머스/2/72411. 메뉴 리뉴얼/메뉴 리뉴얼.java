import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        // 같은 조합이 동일한 문자열로 만들어지도록 문자 정렬
        String[] sortedOrders = new String[orders.length];
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            sortedOrders[i] = new String(chars);
        }
        
        // 코스 길이별로 확인
        for (int courseLength : course) {
            Map<String, Integer> countMap = new HashMap<>();
            // 모든 주문에서 해당 길이의 조합 생성
            for (String order : sortedOrders) {
                if (order.length() < courseLength) {
                    continue;
                }
                
                makeCombination(order, 0, courseLength, new StringBuilder(), countMap);
            }
            
            int maxCount = 0;
        
            for (int count : countMap.values()) {
                maxCount = Math.max(maxCount, count);
            }

            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        result.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    
    private void makeCombination(
        String order,
        int start,
        int targetLength,
        StringBuilder selected,
        Map<String, Integer> countMap
    ) {
        // 목표 길이 도달 (조합 완성)
        if (selected.length() == targetLength) {
            String menu = selected.toString();
            
            countMap.put(
                menu,
                countMap.getOrDefault(menu, 0) + 1
            );
            
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            selected.append(order.charAt(i));
            
            makeCombination(
                order, i + 1, targetLength, selected, countMap
            );
            
            selected.deleteCharAt(selected.length() - 1);
        }
        
    }
}