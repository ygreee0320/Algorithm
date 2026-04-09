import java.util.*;

class Solution {
    public HashSet<Integer> candidates = new HashSet<>();
    public boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        for (int len = 1; len <= numbers.length(); len++) {
            permute(numbers, "", len);
        }
        
        int answer = 0;
        for (int num : candidates) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public void permute(String numbers, String current, int len) {
        if (current.length() == len) {
            candidates.add(Integer.parseInt(current));
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permute(numbers, current + numbers.charAt(i), len);
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별
    public boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}