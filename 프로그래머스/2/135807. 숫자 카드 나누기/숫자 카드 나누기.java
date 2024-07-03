class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        boolean a = true;
        boolean b = true;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                b = false;
                break;
            }
        }
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                a = false;
                break;
            }
        }
        if (a && b) {
            answer = Math.max(gcdA, gcdB);
        } else if (a) {
            answer = gcdA;
        } else if (b) {
            answer = gcdB;
        } else {
            answer = 0;
        }
        return answer;
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}