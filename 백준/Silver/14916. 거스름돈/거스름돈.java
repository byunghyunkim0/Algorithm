import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 거스름돈 액수
		int n = sc.nextInt();
		// 동전의 개수를 담는 dp배열 생성
		int[] dp = new int[100001];
		
		dp[1] = 123456789;
		dp[2] = 1;
		dp[3] = 123456789;
		dp[4] = 2;
		dp[5] = 1;
		
		for (int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
		}
		
		if (dp[n] == 123456789) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n]);
		}
	}
}
