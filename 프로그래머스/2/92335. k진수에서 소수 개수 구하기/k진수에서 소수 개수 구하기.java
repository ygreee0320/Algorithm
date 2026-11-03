class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String nk = Integer.toString(n, k);
        String[] numbers = nk.split("0");
        
        for (String number : numbers) {
            if (number.isEmpty()) continue;
            
            if (isPrime(Long.parseLong(number))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long n) {
        if (n == 1) return false;
        
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}