import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] data = new int[n + 1][2];
		
		for (int i = 1; i < n + 1; i++) {
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}
		
		int[][] dp = new int[n + 1][k + 1];
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < k + 1; j++) {
				if (j < data[i][0]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - data[i][0]] + data[i][1], dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[n][k]);
		
	}
}
