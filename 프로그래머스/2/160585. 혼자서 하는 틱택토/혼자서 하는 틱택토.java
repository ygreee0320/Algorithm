class Solution {
    public int solution(String[] board) {
        int cnt_o = 0;
        int cnt_x = 0;
        
        for (String b : board) {
            for (int i = 0; i < 3; i++) {
                if (b.charAt(i) == 'O') {
                    cnt_o++;
                } else if (b.charAt(i) == 'X') {
                    cnt_x++;
                }
            }
        }
        
        if (!(cnt_o - cnt_x == 1 || cnt_o == cnt_x)) {
            return 0;
        }
        
        int win_o = 0;
        int win_x = 0;
        
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2) && board[i].charAt(0) == 'O') {
                win_o++;
            } else if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2) && board[i].charAt(0) == 'X') {
                win_x++;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i) && board[0].charAt(i) == 'O') {
                win_o++;
            } else if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i) && board[0].charAt(i) == 'X') {
                win_o++;
            }
        }
        
        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2) && board[0].charAt(0) == 'O') {
            win_o++;
        } else if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2) && board[0].charAt(0) == 'X') {
            win_x++;
        }
        
        if (board[2].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[0].charAt(2) && board[2].charAt(0) == 'O') {
            win_o++;
        } else if (board[2].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[0].charAt(2) && board[2].charAt(0) == 'X') {
            win_x++;
        }
        
        if (win_o > 0 && cnt_o != cnt_x + 1) return 0;
        if (win_x > 0 && cnt_x != cnt_o) return 0;
        if (win_o > 0 && win_o == win_x) return 0;
        
        return 1;
    }
}