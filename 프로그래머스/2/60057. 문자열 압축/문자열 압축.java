class Solution {
    public int solution(String s) {
        int n = s.length();
        int limit = n / 2; // 자를 크기
        int answer = s.length();
        
        while (limit > 0) {
            int current = 0; // 현재 길이
            int startIdx = 0;
            int nextIdx = startIdx + limit;
            int cnt = 1; // 반복 횟수
            
            while (startIdx < n) {
                if (nextIdx + limit - 1 >= n) {
                    if (cnt > 1) {
                        current += limit + String.valueOf(cnt).length();
                        
                        if (nextIdx < n) {
                            current += n - nextIdx;
                        }  
                    } else {
                        current += n - startIdx;
                    }
                    
                    break;
                }
                
                String currentString = s.substring(startIdx, startIdx + limit);
                String nextString = s.substring(nextIdx, nextIdx + limit);
                
                if (currentString.equals(nextString)) {
                    cnt++;
                    nextIdx += limit;
                } else {
                    if (cnt > 1) {
                        current += limit + String.valueOf(cnt).length();
                    } else {
                        current += limit;
                    }
                    
                    startIdx = nextIdx;
                    nextIdx = startIdx + limit;
                    cnt = 1;
                }
            }
            
            answer = Math.min(answer, current);
            
            limit--;
        }
        
        return answer;
    }
}