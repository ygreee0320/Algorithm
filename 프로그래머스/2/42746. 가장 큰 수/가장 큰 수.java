import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] sn = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            sn[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(sn,  (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if (sn[0].equals("0")) {
            return "0";
        }
    
        StringBuilder sb = new StringBuilder();
        
        for (String s : sn) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}