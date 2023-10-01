import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] is_d = {3, 4, 2, 1}; // 작은 사각형이 만들어지는 경우
		int max_w = 0; // 큰 사각형의 가로 길이
		int max_h = 0; // 큰 사각형의 세로 길이
		int small_s = 0; // 작은 사각형의 넓이
		int[][] data = new int[6][2];
		// 방향과 길이의 순서로 데이터를 받는다.
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 6; i++) {
			// 가로와 세로의 길이의 최대값을 저장한다.
			if (data[i][0] == 1 || data[i][0] == 2) {
				max_w = Math.max(max_w, data[i][1]);
			} else {
				max_h = Math.max(max_h, data[i][1]);
			}
			// 마지막 값에 대해서는 첫번째 값과 비교하여 작은 사각형이 만들어지는 경우에 작은 사각형의 넓이를 구한다.
			if (i == 5) {
				if (is_d[data[i][0] - 1] == data[0][0]) {
					small_s = data[i][1] * data[0][1];
				}
			} else {
				if (is_d[data[i][0] - 1] == data[i + 1][0]) {
					small_s = data[i][1] * data[i + 1][1];
				}
			}
		}
		int result = ((max_w * max_h) - small_s) * k;
		System.out.println(result);
		sc.close();
	}
}
