import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 색상환
public class Main {
    static final int INF = 1_000_000_003;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 2; i <= n; i++) {
            dp[1][i] = i;
        }
        if (k == 1) {
            System.out.println(n);
            return;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 4; j <= n; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 2]) % INF;
            }
        }
        System.out.println(dp[k][n]);
    }
}