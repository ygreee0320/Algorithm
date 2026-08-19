class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int current = sequence[0];
        int min_len = 10000000;
        
        while (left <= right) {
            if (current == k) {
                int len = right - left + 1;
                
                if (len < min_len) {
                    min_len = len;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                current -= sequence[left];
                left++;
            } 
            
            else if (current < k) {
                if (right + 1 >= sequence.length) {
                    break;
                }
                
                right++;
                current += sequence[right];
            }
            
            else {
                current -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}