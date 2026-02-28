import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] < numbers[i + 1]) {
                answer[i] = numbers[i + 1];
            } else if (numbers[i] == numbers[i + 1]) {
                answer[i] = answer[i + 1];
            } else {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (answer[j] == -1) {
                        break;
                    }
                    if (answer[j] > numbers[i]) {
                        answer[i] = answer[j];
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}