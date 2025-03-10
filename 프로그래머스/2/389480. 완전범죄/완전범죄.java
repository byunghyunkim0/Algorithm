class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        for (int[] a : info) {
            answer += a[0];
        }
        
        int[][] dp = new int[info.length + 1][m];
        
        for (int i = 1; i <= info.length; i++) {
            for (int j = 0; j < m; j++) {
                if (j < info[i - 1][1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - info[i - 1][1]] + info[i - 1][0]);
            }
        }
        
        answer -= dp[info.length][m - 1];
        if (answer >= n) {
            return -1;
        }
        
        return answer;
    }
}