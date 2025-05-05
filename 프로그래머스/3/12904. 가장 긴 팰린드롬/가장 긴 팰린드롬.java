import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (ch[j] != ch[i + j]) {
                    continue;
                }
                if (i < 2) {
                    dp[j][j + i] = i + 1;
                    continue;
                }
                if (dp[j + 1][j + i - 1] == 0) {
                    continue;
                }
                dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
}