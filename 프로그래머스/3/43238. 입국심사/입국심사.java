class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        long end = Long.MAX_VALUE;
        long mid = (start + end) / 2;
        while (start < end) {
            if (check(mid, n, times)) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }
    
    public static boolean check(long t, int n, int[] time) {
        long temp = n;
        for (int i = 0; i < time.length; i++) {
            temp -= (long)t / time[i];
            if (temp <= 0) {
                return true;
            }
        }
        return false;
    }
}