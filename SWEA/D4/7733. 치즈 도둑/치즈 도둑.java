import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static int[][] cheese;
	public static boolean[][] visited;
	public static int n;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TEST = sc.nextInt();
		
		for (int testCase = 1; testCase <= TEST; testCase++) {
			// 치즈의 한 변의 길이
			n = sc.nextInt();
			
			// 치즈의 정보를 담을 배열 생성
			cheese = new int[n][n];
			
			// 결과를 담을 변수
			int result = 0;
			
			// 정보 받기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			
			// 일수에 대해서 덩어리의 개수를 세기
			for (int i = 0; i < 100; i++) {
				visited = new boolean[n][n];
				// 최대값만 저장한다.
				result = Math.max(result, xday(i));
			}
			
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	// x번째날에 대해서 덩어리의 개수를 갱신하는 메서드
	public static int xday(int x) {
		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 해당 좌표가 방문하지않았다면 dfs를 통해 방문을 갱신하고 count++
				// 치즈의 맛정도가 x보다 큰 것만 방문한다.
				if (!visited[i][j] && cheese[i][j] > x) {
					count++;
					DFS(i, j, x);
				}
			}
		}
		return count;
	}
	
	// dfs
	public static void DFS(int x, int y, int day) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && cheese[nx][ny] > day) {
				visited[nx][ny] = true;
				DFS(nx, ny, day);
			}
		}
	}
}
