class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int flag = 1;
        
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        answer = Math.max(dp[0][0], dp[0][1]);
        
        for (int i = 1; i < sequence.length; i++) {
            if (flag == 1) {
                dp[i][0] = Math.max(dp[i - 1][0] - sequence[i], dp[i][0]);
                dp[i][1] = Math.max(dp[i - 1][1] + sequence[i], dp[i][1]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0] + sequence[i], dp[i][0]);
                dp[i][1] = Math.max(dp[i - 1][1] - sequence[i], dp[i][1]);
            }
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
            flag *= -1;
        }
        return answer;
    }
}