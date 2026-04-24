class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int t = 0;
        int waiting_idx = 0;
        int n = truck_weights.length;
        int[] bridge = new int[bridge_length];
        
        while (waiting_idx < n) {
            t++;
            int w = 0;
            
            for (int i = 0; i < bridge_length - 1; i++) {
                bridge[i] = bridge[i + 1];
                w += bridge[i + 1];
            }
            
            bridge[bridge_length - 1] = 0;
            
            if (w + truck_weights[waiting_idx] <= weight) {
                bridge[bridge_length - 1] = truck_weights[waiting_idx];
                waiting_idx++;
            }
        }
        
        int final_idx = -1;
        
        for (int i = bridge_length - 1; i >= 0; i--) {
            if (bridge[i] != 0) {
                final_idx = i;
                break;
            }
        }
        
        t += (final_idx + 1);
        
        return t;
    }
}