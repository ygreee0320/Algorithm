import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int N = files.length;
        String[][] new_files = new String[N][3];
        
        // HEAD, NUMBER 찾기
        for (int i = 0; i < N; i++) {
            int start_num = -1;
            int end_num = files[i].length();
            
            for (int j = 0; j < files[i].length(); j++) {
                Character target = files[i].charAt(j);
                
                if (target >= '0' && target <= '9') {
                    if (start_num == -1) {
                        start_num = j;
                    }
                } else if (start_num != -1) {
                    end_num = j;
                    break;
                }
            }
            
            String head = files[i].substring(0, start_num);
            String number = files[i].substring(start_num, end_num);
            int num = Integer.parseInt(number);
            
            new_files[i] = new String[]{files[i], head.toLowerCase(), Integer.toString(num)};
        }
        
        Arrays.sort(new_files, (a, b) -> {
            if (a[1].equals(b[1])) {
                return Integer.compare(
                    Integer.parseInt(a[2]),
                    Integer.parseInt(b[2])
                );
            }
            
            return a[1].compareTo(b[1]);
        });
        
        String[] answer = new String[N];
        
        for(int i = 0; i < N; i++) {
            answer[i] = new_files[i][0];
        }
        
        return answer;
    }
}