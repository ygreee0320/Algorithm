import java.util.*;

class Solution {
    public String solution(String p) {
        if (isCorrect(p)) return p;
        
        return program(p);
    }
    
    private String program(String w) {
        if (w.isEmpty()) return "";
        
        String u = "";
        String v = "";
        int countA = 0;
        int countB = 0;
        
        for (int i = 0; i < w.length(); i++) {
            char target = w.charAt(i);
            
            if (target == '(') {
                countA++;
            } else {
                countB++;
            }
            
            if (countA == countB) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1, w.length());
                break;
            }
        }
        
        if (isCorrect(u)) {
            return u + program(v);
        }
        
        StringBuilder result = new StringBuilder();
        result.append("(").append(program(v)).append(")");
            
        for (int i = 1; i < u.length() - 1; i++) {
            result.append(u.charAt(i) == '(' ? ")" : "(");
        }
            
        return result.toString();
    }
    
    private boolean isCorrect(String w) {
        Stack<Character> st = new Stack<>();
        
        int countA = 0; // '(' 개수
        int countB = 0; // ')' 개수
        
        for(int i = 0; i < w.length(); i++) {
            char target = w.charAt(i);
            
            if (target == '(') {
                countA++;
                st.push(target);
            } else {
                countB++;
                
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        
        if (countA != countB) return false;
        
        return true;
    }
}