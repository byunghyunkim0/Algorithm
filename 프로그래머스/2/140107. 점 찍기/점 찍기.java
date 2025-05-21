class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long max = (long)Math.pow(d, 2);
        for (int i = 0; i <= d; i += k) {
            long temp = max - (long)Math.pow(i, 2);
            answer += ((long)Math.sqrt(temp)) / k + 1;
        }
        return answer;
    }
}
