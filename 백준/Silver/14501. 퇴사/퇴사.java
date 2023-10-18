import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 일수에 대한 정보
		int n = sc.nextInt();
		
		// 일수의 크기만큼 ti와 pi를 받는 배열 생성
		int[][] s = new int[n][2];
		
		// dp테이블 생성
		int[] dp = new int[n + 1];
		
		// 데이터 받기
		for (int i = 0; i < n; i++) {
			s[i][0] = sc.nextInt();
			s[i][1] = sc.nextInt();
		}
		
		// 뒤에서부터 판단
		for (int i = n - 1; i >= 0; i--) {
			if (i + s[i][0] > n) {
				// i와 pi가 n보다 크다면 상담을 진행할수없으므로 i + 1의 값을 가져온다.
				dp[i] = dp[i + 1];
			} else {
				// 상담을 진행할수있으므로 해당 인덱스에서의 상담을 진행한것과 이전 값을 비교해서 최대값을 가져온다.
				dp[i] = Math.max(dp[i + s[i][0]] + s[i][1], dp[i + 1]);
			}
		}
		
		// 결과 출력
		System.out.println(dp[0]);
	}
}
