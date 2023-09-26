import java.util.Scanner;

public class Main {
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static int count = 0;
	public static char[][] cam;
	public static boolean[][] visited;
	public static int n;
	public static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 캠퍼스 정보 받을 배열
		cam = new char[n][m];
		
		// 시작 위치 설정
		int startx = 0;
		int starty = 0;
		
		// 방문 배열
		visited = new boolean[n][m];
		
		// 데이터 받기, 시작위치 설정
		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			for (int j = 0; j < m; j++) {
				cam[i][j] = temp.charAt(j);
				if (cam[i][j] == 'I') {
					startx = i;
					starty = j;
				}
			}
		}
		
		// 재귀, P의 개수 찾기
		DFS(startx, starty);
		
		// 출력
		if (count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
		
	}
	
	public static void DFS(int x, int y) {
		if (cam[x][y] == 'P') {
			// 방문한 위치의 값이 P이면 count를 +1해준다.
			count++;
		}
		
		for (int i = 0; i < 4; i++) {
			// 다음 위치
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위 내에 방문하지 않았으면 방문처리하고 재귀
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && cam[nx][ny] != 'X') {
				visited[nx][ny] = true;
				DFS(nx, ny);
			}
		}
	}
}
