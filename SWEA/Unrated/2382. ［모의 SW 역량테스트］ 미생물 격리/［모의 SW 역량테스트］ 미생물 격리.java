import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static PriorityQueue<int[]>[][] map;
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TEST = sc.nextInt();
		
		for (int testCase = 1; testCase <= TEST; testCase++) {
			// 한변의 길이
			n = sc.nextInt();
			// 격리 시간
			int m = sc.nextInt();
			// 최초 배치되어있는 미생물 수
			int k = sc.nextInt();
			
			int result = 0;
			
			// 격리실의 배열
			// map[i][j][0] : 위치의 미생물의 수 map[i][j][1] : 이동방향
			map = new PriorityQueue[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = new PriorityQueue<>(new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[0] - o2[0];
						}
					});
				}
			}
			
			for (int i = 0; i < k; i++) {
				// 세로위치
				int r = sc.nextInt();
				// 가로위치
				int c = sc.nextInt();
				// 미생물의 수
				int mi = sc.nextInt();
				// 방향
				int d = sc.nextInt() - 1;
				
				// 격리실의 정보 넣기
				map[r][c].add(new int[] {mi, d});
			}
			
			// 시간 보내기
			for (int time = 0; time < m; time++) {
				// 이동
				move();
				
				// 분열
				sum();
			}
			
			// 결과 구하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!map[i][j].isEmpty()) {
						result += map[i][j].remove()[0];
					}
				}
			}
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	// 이동하는 메서드
	public static void move() {
		// 이동하는 미생물들의 이동 정보를 담을 큐
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 해당 좌표에 미생물이 있다면
				if (!map[i][j].isEmpty()) {
					int[] cur = map[i][j].remove();
					// 해당 위치의 미생물 양의 정보
					int count = cur[0];
					// 방향에 대한 정보
					int d = cur[1];
					
					// nx, ny로 이동
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					// 이동할 장소가 약품이 칠해져있다면
					if (nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) {
						// 방향을 수정
						if (d == 0) {
							d = 1;
						} else if (d == 1) {
							d = 0;
						} else if (d == 2) {
							d = 3;
						} else {
							d = 2;
						}
						// 미생물의 양 반으로 줄이기
						count = count / 2;
					}
					// 이동 위치에 대한 정보를 queue에 넣기
					// 위치, 미생물의 양, 방향
					queue.add(new int[] {nx, ny, count, d});
					
				}
			}
		}
		
		// 이동할 정보를 다 담았다면
		while (!queue.isEmpty()) {
			// queue의 정보를 이용하여 최신화
			int[] data = queue.remove();
			// data : [x좌표, y좌표, 미생물의 양, 방향]
			map[data[0]][data[1]].add(new int[] {data[2], data[3]});
		}
	}
	
	// 두 개 이상의 군집이 한 셀에 모여있다면 합치기
	public static void sum() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() > 1) {
					// 해당 위치에 2개 이상의 정보가 담겨있다면 합쳐야한다.
					// 미생물의 수
					int count = 0;
					// 방향 정보
					int d = 0;
					while (!map[i][j].isEmpty()) {
						// data = {미생물의 양, 방향}
						int[] data = map[i][j].remove();
						
						// 우선순위 큐로 정보를 저장했기 때문에 미생물의 양이 가장 많은 것이 나중에 나온다.
						// 그래서 방향을 계속 갱신한다.
						d = data[1];
						// 해당 위치의 미생물의 수를 증가시켜준다.
						count += data[0];
					}
					// 해당 위치의 미생물의 정보 갱신
					map[i][j].add(new int[] {count, d});
				}
			}
		}
	}
}