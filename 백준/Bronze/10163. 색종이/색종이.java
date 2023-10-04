import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[1001][1001];
		int[] result = new int[101];
		for (int t = 0; t < n; t++) {
			int x_1 = sc.nextInt();
			int y_1 = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for (int i = x_1; i < x_1 + w; i++) {
				for (int j = y_1; j < y_1 + h; j++) {
					board[i][j] = t + 1;
				}
			}
		}
		for(int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				result[board[i][j]]++;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			System.out.println(result[i]);
		}
		
	}
}
