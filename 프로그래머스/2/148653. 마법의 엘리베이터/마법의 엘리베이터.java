class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 일의 자리부터 0으로 만들기
        while (storey > 0) {
            int digit = storey % 10;
            int nextDigit = (storey / 10) % 10;
            
            if (digit < 5) { // 내림
                answer += digit;
                storey /= 10;
            } else if (digit > 5) { // 올림
                answer += 10 - digit;
                storey = storey / 10 + 1;
            } else { 
                answer += 5;
                
                // 그 다음 수로 판단
                if (nextDigit >= 5) {
                    storey = storey / 10 + 1; // 올림
                } else {
                    storey /= 10;
                }
            }
        }
        
        return answer;
    }
}