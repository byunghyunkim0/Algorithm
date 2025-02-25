class Solution {
    static int gcd;
    public long solution(int w, int h) {
        long answer = w * h;
        
        long nw = (long)w;
        long nh = (long)h;
        return nw * nh - (nw + nh - gcd(nw, nh));
    }
    
    static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}