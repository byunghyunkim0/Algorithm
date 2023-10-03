import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[5001];
		
		dp[1] = 123456789;
		dp[2] = 123456789;
		dp[3] = 1;
		dp[4] = 123456789;
		dp[5] = 1;
		
		for (int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
		}
		
		if (dp[n] >= 123456789) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n]);
		}
	}
}
