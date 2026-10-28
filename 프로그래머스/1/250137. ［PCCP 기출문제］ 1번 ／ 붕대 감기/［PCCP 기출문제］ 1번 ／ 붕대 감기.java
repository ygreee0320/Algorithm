class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int current_time = 0;
        int idx = 0; // attack 인덱스
        int straight_cnt = 0; //연속 횟수
        
        while(idx < attacks.length) {
            int attack_time = attacks[idx][0];
            int damage = attacks[idx][1];
            
            if (current_time == attack_time) {
                answer -= damage;
                straight_cnt = 0;
                idx++;
                
                if (answer <= 0) return -1;
            } else {
                answer = Math.min(health, answer + x);
                straight_cnt++;
            }
            
            if (straight_cnt == t) {
                answer = Math.min(health, answer + y);
                straight_cnt = 0;
            }
            
            current_time++;
        }
        
        if (answer <= 0) {
            return -1;
        } else {
            return answer;
        }
    }
}