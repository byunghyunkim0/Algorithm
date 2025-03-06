class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int n = park.length;
        int m = park[0].length;
        
        int[][] dp = new int[n][m];
        
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!park[i][j].equals("-1")) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        
        for (int len : mats) {
            if (maxLen < len) {
                continue;
            }
            answer = Math.max(answer, len);
        }
        return answer;
    }
}