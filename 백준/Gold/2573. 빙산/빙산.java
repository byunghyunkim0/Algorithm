import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int year = 0;
	public static boolean[][] visited;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	public static int n;
	public static int m;
	public static int[][] ice;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 빙산의 정보를 담을 배열 생성
		ice = new int[n][m];
		
		// 빙산에 대한 정보 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ice[i][j] = sc.nextInt();
			}
		}
		
		while (true) {
			// 덩어리가 생길때까지
			// dfs함수를 몇 번 호출했는지
			int count = 0;
			// 방문을 확인하는 배열 생성
			visited = new boolean[n][m];
			
			// 맵을 하나씩 방문
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (ice[i][j] == -1) {
						ice[i][j] = 0;
					}
					
					// 해당 정보다 0이 아니고 방문도 안했다면 dfs시작
					if (ice[i][j] != 0 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						count++;
					}
				}
			}
			
			if (count == 0) {
				// count가 0이면 빙산이 모두 녹은 것이므로 0을 출력
				// dfs를 한번도 방문하지 않았다.
				// while문을 벗어난다.
				year = 0;
				break;
			} else if (count == 1) {
				// dfs를 한번 방문함 빙산이 아직도 녹고있는중
				year++;
			} else {
				break;
			}
		}
		
		// 결과 출력
		System.out.println(year);
		
	}
	
	public static void dfs(int x, int y) {
		// 주위의 0의 개수
		int c = 0;
		
		// 주위의 0의 개수 세기
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && ice[nx][ny] == 0) {
				c++;
			}
		}
		// 해당 빙산이 c보다 작거나 같으면 -1로 바꿔준다.
		if (ice[x][y] <= c) {
			ice[x][y] = -1;
		} else {
			ice[x][y] -= c;
		}
		
		// 갈수있는 방향으로 dfs를 진행하고 방문처리도 진행
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && ice[nx][ny] != 0) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}
