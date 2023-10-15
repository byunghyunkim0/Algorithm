import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 크기
		int n = sc.nextInt();
		
		// 최대 수열의 길이
		int result = 0;

		// 수열의 정보를 담기위한 배열 생성
		int[] arr = new int[n];

		// 데이터 받기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 바이토닉 수열에 대한 길이를 담을 2차원 dp테이블 생성
		int[][] dp = new int[n][n];

		for (int maxindex = 0; maxindex < n; maxindex++) {
			// maxindex를 기준으로 왼쪽은 증가하는 수열 오른쪽은 감소하는 수열의 길이를 받기

			// 왼쪽에 해당하는 증가하는 수열의 길이를 작성
			for (int i = 1; i <= maxindex; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) {
						dp[maxindex][i] = Math.max(dp[maxindex][i], dp[maxindex][j] + 1);
					}
				}
			}
			
			for (int i = maxindex + 1; i < n; i++) {
				for (int j = maxindex; j < i; j++) {
					if (arr[i] < arr[j]) {
						dp[maxindex][i] = Math.max(dp[maxindex][i], dp[maxindex][j] + 1);
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, dp[i][j]);
			}
		}
		System.out.println(result + 1);

	}
}
