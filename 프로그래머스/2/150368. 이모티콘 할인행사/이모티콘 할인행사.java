class Solution {
    int n, m;
    int[] discount = new int[]{10, 20, 30, 40};
    int[] answer = new int[]{-1, -1};
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        
        makeCombination(users, emoticons, new int[m], 0);
        
        return answer;
    }
    
    // 조합 생성
    private void makeCombination(int[][] users, int[] emoticons, int[] selectedDiscount, int idx) {
        if (idx == m) {
            int total_user = 0;
            int total_cost = 0;
            
            for (int[] user : users) {
                int cost = 0;
                
                for (int i = 0; i < m; i++) {
                    if (selectedDiscount[i] >= user[0]) { // 구매
                        cost += emoticons[i] * (100 - selectedDiscount[i]) / 100;
                    }
                }
                
                if (cost >= user[1]) {
                    total_user++;
                } else {
                    total_cost += cost;
                }
            }
            
            if (total_user > answer[0] || (total_user == answer[0] && total_cost > answer[1])) {
                answer[0] = total_user;
                answer[1] = total_cost;
            }
            
            return;
        }
        
        for (int d : discount) {
            selectedDiscount[idx] = d;
            makeCombination(users, emoticons, selectedDiscount, idx + 1);
        }
        
        return;
    }
}