class Solution {
    static final long INF = 1000000007;
    public int solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        long[] dp = new long[n + 1];
        long[] sum = new long[n + 1];
        dp[2] = 3;
        sum[2] = 1;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            dp[i] %= INF;
            dp[i] += sum[i - 2] * 2;
            dp[i] %= INF;
            sum[i] = sum[i - 2] + dp[i - 2];
            sum[i] %= INF;
        }
        return (int)dp[n];
    }
}