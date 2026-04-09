class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow; // 전체 격자 수
        
        // 세로는 최소 3부터 시작 (갈색 + 노란색 + 갈색)
        for (int h = 3; h < total; h++) {
            if (total % h == 0) {
                int w = total / h; // 가로 길이 계산
                
                // 노란색 격자 수 조건 확인
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}