import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] dp;
    static int n;
    static int[][] cost;
    static final int INF = 123456789;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        dp = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 1));
    }

    static int dfs(int cur, int visite) {
        if (visite == (1 << n) - 1) {
            if (cost[cur][0] == 0) {
                return INF;
            }
            return cost[cur][0];
        }

        if (dp[cur][visite] != -1) {
            return dp[cur][visite];
        }
        dp[cur][visite] = INF;

        for (int i = 0; i < n; i++) {
            if ((visite & (1 << i)) == 0 && cost[cur][i] != 0) {
                dp[cur][visite] = Math.min(dp[cur][visite], dfs(i, visite | (1 << i)) + cost[cur][i]);
            }
        }
        return dp[cur][visite];
    }
}