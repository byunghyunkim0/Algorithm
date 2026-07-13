class Solution {
    public int solution(int[][] signals) {
        f:for (int i = 0; i < 3000000; i++) {
            for (int[] signal : signals) {
                if (!check(signal[0], signal[1], signal[2], i)) {
                    continue f;
                }
            }
            return i;
        }
        return -1;
    }
    
    boolean check(int green, int yellow, int red, int time) {
        int a = time % (green + yellow + red);
        if (a > green && a <= green + yellow) {
            return true;
        }
        return false;
    }
}