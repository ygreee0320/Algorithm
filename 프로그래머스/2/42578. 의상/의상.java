import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];
            
            if (!map.containsKey(type)) {
                map.put(type, new ArrayList<>());
            } 
            
            map.get(type).add(name);
        }
        
        int answer = 1;
        for (String key : map.keySet()) {
            // 해당 종류의 옷 개수(리스트 크기) + 1(해당 종류 안 입는 경우)
            answer *= (map.get(key).size() + 1);
        }
        
        // 아무것도 입지 않는 경우 1가지 제외
        return answer - 1;
    }
}