class Solution {
    public int solution(int[][] sizes) {
        int w = 0; // max
        int h = 0; // min
        
        for (int i = 0; i < sizes.length; i++) {
            int max_s = Math.max(sizes[i][0], sizes[i][1]);
            int min_s = Math.min(sizes[i][0], sizes[i][1]);
            
            w = Math.max(w, max_s);
            h = Math.max(h, min_s);
        }
        
        int answer = w * h;
        return answer;
    }
}