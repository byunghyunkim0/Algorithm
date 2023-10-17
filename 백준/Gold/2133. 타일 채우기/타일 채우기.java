import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] dp = new int[31];

		dp[0] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0) {
				dp[i] = dp[i - 2] * 3;
				for (int j = 0; j < i - 2; j += 2) {
					dp[i] += dp[j] * 2;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
