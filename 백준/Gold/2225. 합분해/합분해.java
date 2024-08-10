import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                for (int a = 1; a <= i; a++) {
                    dp[i][j] += dp[a][j - 1];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= k; i++) {
            result += dp[n][i];
            result %= 1000000000;
        }
        System.out.println(result);
    }
}