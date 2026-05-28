class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        
        quard(arr, answer, arr.length, 0, 0);
        
        return answer;
    }
    
    public void quard(int[][] arr, int[] answer, int size, int start_x, int start_y) {
        int num = arr[start_x][start_y];
        
        if (size == 1) {
            answer[num]++;
            return;
        }
        
        boolean flag = true; // 압축 가능 여부
        for (int i = start_x; i < start_x + size; i++) {
            for (int j = start_y; j < start_y + size; j++) {
                if (num != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        
        if (flag) {
            answer[num]++;
            return;
        } else {
            int new_size = size / 2;
            quard(arr, answer, new_size, start_x, start_y);
            quard(arr, answer, new_size, start_x + new_size, start_y);
            quard(arr, answer, new_size, start_x, start_y + new_size);
            quard(arr, answer, new_size, start_x + new_size, start_y + new_size);
        }
    }
}