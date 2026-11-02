class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean possibleA = true;
        boolean possibleB = true;
        
        for (int a : arrayA) {
            if (a % gcdB == 0) {
                possibleB = false;
                break;
            }
        }
        
        for (int b : arrayB) {
            if (b % gcdA == 0) {
                possibleA = false;
                break;
            }
        }
        
        if (possibleA && possibleB) {
            return Math.max(gcdA, gcdB);
        } else if (possibleA) {
            return gcdA;
        } else if (possibleB) {
            return gcdB;
        } else {
            return 0;
        }
    }
    
    private int gcd(int a, int b) { // 최대 공약수 계산
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        
        return a;
    }
}