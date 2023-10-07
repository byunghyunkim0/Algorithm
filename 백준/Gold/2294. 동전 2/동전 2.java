import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		List<Integer> coins = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int coin = sc.nextInt();
			if (coin > 10000) {
				continue;
			}
			coins.add(coin);
		}
		
		int[] dp = new int[10001];
		for (int i = 1; i <= 10000; i++) {
			dp[i] = 123456789;
		}
		
		
		for (int i = 1; i <= k; i++) {
			for (int coin : coins) {
				if (i == coin) {
					dp[i] = 1;
				} else if (i < coin) {
					continue;
				} else {
					dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
				}
			}
		}
		if (dp[k] > 100000000) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}
