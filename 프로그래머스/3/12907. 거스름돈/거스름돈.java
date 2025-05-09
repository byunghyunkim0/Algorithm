import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int INF = 1000000007;
        int[] dp = new int[n + 1];
        dp[0]++;
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] += dp[i - m];
                dp[i] %= INF;
            }
        }
        answer = dp[n];
        return answer;
    }
}