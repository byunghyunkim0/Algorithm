import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[][] dp = new int[k + 1][2];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
        }
        System.out.println(dp[k][0] + " " + dp[k][1]);
    }
}