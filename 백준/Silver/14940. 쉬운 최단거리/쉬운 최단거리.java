import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		Scanner sc = new Scanner(System.in);
		
		// 지도의 크리 n, m을 받는다.
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		// 시작 위치에 대한 좌표
		int x = 0;
		int y = 0;
		// 데이터 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					// 해당 위치가 시작위치이면
					x = i;
					y = j;
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {x, y, 0});
		
		// 출력을 위한 sb
		StringBuilder sb = new StringBuilder();
		
		// bfs
		while (!queue.isEmpty()) {
			int[] data = queue.remove();
			visited[data[0]][data[1]] = true;
			map[data[0]][data[1]] = data[2];
			for (int i = 0; i < 4; i++) {
				int nx = data[0] + dx[i];
				int ny = data[1] + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, data[2] + 1});
				}
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					sb.append("-1 ");
				} else {
					sb.append(map[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		
	}
}
