class Solution {
    int t = 3; // 목표 개수
    int answer = 0;
    
    public int solution(int[] nums) {
        makeCombination(nums, 0, 0, 0);

        return answer;
    }
    
    // 조합 생성
    private void makeCombination(int[] nums, int current, int start, int count) {
        if (count == t) {
            if (!isPrime(current)) {
                answer++;
            }
            
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            makeCombination(nums, current + nums[i], i + 1, count + 1);
        }
        
        return;
    }
    
    // 소수 판별
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        
        return false;
    }
}