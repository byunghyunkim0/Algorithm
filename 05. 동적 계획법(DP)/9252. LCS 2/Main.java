import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        String str1 = br.readLine();
        String str2 = br.readLine();

        // when
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        char[] result = new char[dp[n][m]];
        int x = n;
        int y = m;
        int index = dp[n][m] - 1;
        while (x > 0 && y > 0) {
            if (dp[x][y] == dp[x - 1][y]) {
                x--;
            } else if (dp[x][y] == dp[x][y - 1]) {
                y--;
            } else {
                result[index--] = str1.charAt(x - 1);
                x--;
                y--;
            }
        }

        // then
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n][m]).append("\n");
        if (dp[n][m] != 0) {
            for (char c : result) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}