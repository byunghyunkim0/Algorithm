import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[][] board;
	public static int n;
	public static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 보드의 크기
		n = sc.nextInt();

		// 보드 배열 생성
		board = new int[n][n];
		// 보드 정보 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		result = 0;
		DFS(board, 0);

		// 최대 결과값, 출력
		System.out.println(result);
	}

	public static void DFS(int[][] map, int count) {
		if (count == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result = Math.max(result, map[i][j]);
				}
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 복사
			int[][] copyMap = new int[n][n];
			for (int j = 0; j < n; j++) {
				copyMap[j] = map[j].clone();
			}
			// i방향으로 이동하기
			move(copyMap, i);

			// 이동한 배열 DFS에 넣기
			// 연산횟수 count + 1
			DFS(copyMap, count + 1);
		}
	}

	// 방향에 따라 이동시키는 메서드
	// 이동시킬 배열 map, 방향 d
	// 0, 1, 2, 3 : 상, 하, 좌, 우
	public static void move(int[][] map, int d) {
		if (d == 0) {
			// 보드의 숫자를 위로 옮기기
			for (int j = 0; j < n; j++) {
				// 한줄의 정보를 저장하는 queue생성
				Queue<Integer> queue = new LinkedList<>();
				for (int i = 0; i < n; i++) {
					// queue에 한줄의 정보 넣기
					if (map[i][j] != 0) {
						queue.add(map[i][j]);
						map[i][j] = 0;
					}
				}
				// 현재 숫자를 넣을 위치에 대한 정보
				int index = 0;
				if (!queue.isEmpty()) {
					// 처음에는 map[index][j]에 정보를 넣고 queue의 첫번째 값과 비교해서 넣음
					map[index][j] = queue.remove();
				}
				while (!queue.isEmpty()) {
					// 지금 넣으려고 하는 위치와 queue의 첫번째 값과 같다면
					if (map[index][j] == queue.peek()) {
						// 현재 넣으려는 위치에 더해줌 2배를 곱한것과 같음
						map[index++][j] += queue.remove();
					} else if (map[index][j] == 0) {
						map[index][j] = queue.remove();
					} else {
						// 현재 넣으려는 위치의 값과 다르다면 그 다음 위치에 넣는다.
						map[++index][j] = queue.remove();
					}
				}
			}
		} else if (d == 1) {
			// 보드의 숫자를 아래로 옮기기
			for (int j = 0; j < n; j++) {
				// 한줄의 정보를 저장하는 queue생성
				Queue<Integer> queue = new LinkedList<>();
				for (int i = n - 1; i >= 0; i--) {
					if (map[i][j] != 0) {
						// queue에 한줄의 정보 넣기
						queue.add(map[i][j]);
						map[i][j] = 0;
					}
				}
				// 현재 숫자를 넣을 위치에 대한 정보
				int index = n - 1;
				if (!queue.isEmpty()) {
					// 처음에는 map[index][j]에 정보를 넣고 queue의 첫번째 값과 비교해서 넣음
					map[index][j] = queue.remove();
				}
				while (!queue.isEmpty()) {
					// 지금 넣으려고 하는 위치와 queue의 첫번째 값과 같다면
					if (map[index][j] == queue.peek()) {
						// 현재 넣으려는 위치에 더해줌 2배를 곱한것과 같음
						map[index--][j] += queue.remove();
					} else if (map[index][j] == 0) {
						map[index][j] = queue.remove();
					} else {
						// 현재 넣으려는 위치의 값과 다르다면 그 다음 위치에 넣는다.
						map[--index][j] = queue.remove();
					}
				}
			}
		} else if (d == 2) {
			// 보드의 숫자를 왼쪽으로 옮기기
			for (int i = 0; i < n; i++) {
				// 한줄의 정보를 저장하는 queue생성
				Queue<Integer> queue = new LinkedList<>();
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						// queue에 한줄의 정보 넣기
						queue.add(map[i][j]);
						map[i][j] = 0;
					}
				}
				// 현재 숫자를 넣을 위치에 대한 정보
				int index = 0;
				if (!queue.isEmpty()) {
					// 처음에는 map[index][j]에 정보를 넣고 queue의 첫번째 값과 비교해서 넣음
					map[i][index] = queue.remove();
				}
				while (!queue.isEmpty()) {
					// 지금 넣으려고 하는 위치와 queue의 첫번째 값과 같다면
					if (map[i][index] == queue.peek()) {
						// 현재 넣으려는 위치에 더해줌 2배를 곱한것과 같음
						map[i][index++] += queue.remove();
					} else if (map[i][index] == 0) {
						map[i][index] = queue.remove();
					} else {
						// 현재 넣으려는 위치의 값과 다르다면 그 다음 위치에 넣는다.
						map[i][++index] = queue.remove();
					}
				}
			}
		} else {
			// 보드의 숫자를 위로 옮기기
			for (int i = 0; i < n; i++) {
				// 한줄의 정보를 저장하는 queue생성
				Queue<Integer> queue = new LinkedList<>();
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						// queue에 한줄의 정보 넣기
						queue.add(map[i][j]);
						map[i][j] = 0;
					}
				}
				// 현재 숫자를 넣을 위치에 대한 정보
				int index = n - 1;
				if (!queue.isEmpty()) {
					// 처음에는 map[index][j]에 정보를 넣고 queue의 첫번째 값과 비교해서 넣음
					map[i][index] = queue.remove();
				}
				while (!queue.isEmpty()) {
					// 지금 넣으려고 하는 위치와 queue의 첫번째 값과 같다면
					if (map[i][index] == queue.peek()) {
						// 현재 넣으려는 위치에 더해줌 2배를 곱한것과 같음
						map[i][index--] += queue.remove();
					} else if (map[i][index] == 0) {
						map[i][index] = queue.remove();
					} else {
						// 현재 넣으려는 위치의 값과 다르다면 그 다음 위치에 넣는다.
						map[i][--index] = queue.remove();
					}
				}
			}
		}
	}
}
