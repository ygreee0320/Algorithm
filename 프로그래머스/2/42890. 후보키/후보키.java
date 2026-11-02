import java.util.*;

class Solution {
    int answer = 0;
    Set<Integer> candidate_key = new HashSet<>();
    
    public int solution(String[][] relation) {
        for (int s = 1; s <= relation[0].length; s++) {
            combination(relation, new int[relation[0].length], s, 0, 0);
        }
        
        return answer;
    }
    
    private void combination(String[][] relation, int[] key, int size, int start, int depth) {
        if (depth == size) {
            if (!isCandidate(key)) return;
            
            Map<String, Integer> map = new HashMap<>();
            
            for (String[] r : relation) {
                StringBuilder sb = new StringBuilder();
                
                for (int c = 0; c < key.length; c++) {
                    if (key[c] == 1) {
                        sb.append(r[c]).append(" ");
                    }
                }
                
                if (map.containsKey(sb.toString())) {
                    return;
                } else {
                    map.put(sb.toString(), 1);
                }
            }
            
            if (map.size() == relation.length) {
                StringBuilder sb = new StringBuilder();
                
                for (int k : key) {
                    sb.append(Integer.toString(k));
                }
                
                candidate_key.add(Integer.parseInt(sb.toString(), 2));
                answer++;
            }
            
            return;
        }
        
        for (int i = start; i < relation[0].length; i++) {
            key[i] = 1;
            combination(relation, key, size, i + 1, depth + 1);
            key[i] = 0;
        }
    }
    
    private boolean isCandidate(int[] key) {
        StringBuilder sb = new StringBuilder();
        
        for (int k : key) {
            sb.append(Integer.toString(k));
        }
        
        int mask = Integer.parseInt(sb.toString(), 2);
        
        for (Integer k : candidate_key) {
            if ((mask & k) == k) {
                return false;
            }
        }
        
        return true;
    }
}