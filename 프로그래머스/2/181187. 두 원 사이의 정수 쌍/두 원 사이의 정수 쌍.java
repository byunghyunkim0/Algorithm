class Solution {
    public long solution(int r1, int r2) {
        long answer = (long)(r2 - r1 + 1) * 4;
        for (long i = 1; i < r2; i++) {
            answer += (long)(Math.sqrt((long)r2 * r2 - i * i)) * 4;
            if (i >= r1) {
                continue;
            }
            answer -= (long)(Math.sqrt((long)r1 * r1 - i * i)) * 4;
            long temp = (long)r1 * r1 - i * i;
            if (temp != 0 && Math.sqrt(temp) % 1 == 0) {
                answer += 4;
            }
        }
        return answer;
    }
}