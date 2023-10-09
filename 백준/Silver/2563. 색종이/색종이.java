import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 색종이의 개수 정보 받기
		int result = 0; // 결과값
		
		// 100 x 100 크기의 배열 생성
		int[][] board = new int[100][100];
		
		for (int t = 0; t < n; t++) {
			int c = sc.nextInt(); // 주어진 색종이의 열의 값
			int r = sc.nextInt(); // 주어진 색종이의 행의 값
			
			// 10 x 10 크기의 범위의 값을 1로 만들어줌
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					board[c + i][r + j] = 1;
				}
			}
		}
		
		// 1의 개수 구하기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				result += board[i][j];
			}
		}
		
		System.out.println(result);
	}
}
