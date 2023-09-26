import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static List<Integer>[] graph;
	public static int n;
	public static int[] people;
	public static boolean[] visited;
	public static int ans = Integer.MAX_VALUE;;
	public static int num = 1;
	public static Stack<Integer> A = new Stack<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 구역의 개수
		n = sc.nextInt();
		
		// 각 지역의 인구의 수 저장할 배열
		people = new int[n];
		
		// graph
		graph = new ArrayList[n];

		// 인구의 정보 저장
		for (int i = 0; i < n; i++) {
			people[i] = sc.nextInt();
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; i++) {
			// 해당 지역과 연결된 간선의 수
			int e = sc.nextInt();
			
			for (int j = 0; j < e; j++) {
				// 해당 지역에 연결된 지역들 추가
				int b = sc.nextInt();
				graph[i].add(b - 1);
				graph[b - 1].add(i);
			}
		}
		// 한개의 조합마다 구역의 수
		// n / 2만큼만 해도됨
		// A : [0] B : [1, 2, 3, 4, 5]와 A : [1, 2, 3, 4, 5] B : [0]은 값이 똑같기때문에
		for (int i = 0; i < n / 2; i++) {
			combination(0, 0);
			num++;
		}
		if (ans == Integer.MAX_VALUE) {
			// ans의 값에서 변경이 없다면 -1을 출력
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}
	}
	
	// 조합을 num만큼 뽑음
	public static void combination(int idx, int pidx) {
		if (idx == num) {
			// A 선거구에 해당하는 구역을 제외하고 B선거구에 넣는다.
			List<Integer> B = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (A.contains(i)) {
					continue;
				}
				B.add(i);
			}
			
			// 방문 배열
			visited = new boolean[n];
			
			Queue<Integer> queue = new LinkedList<>();
			
			// A 인접한 구역에 대해서 방문 BFS
			// 방문한 곳에 대해서 visited를 true로 바꾼다.
			// 방문하지 않은 구역이 있으면 이후에 계산을 하지않는다. 방문하지 않는 구역이 있다면 연결되어있지 않다는 뜻
			queue.add(A.get(0));
			visited[A.get(0)] = true;
			while (!queue.isEmpty()) {
				int data = queue.remove();
				
				for (int n : graph[data]) {
					if (A.contains(n) && !visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
			queue.add(B.get(0));
			visited[B.get(0)] = true;
			while (!queue.isEmpty()) {
				int data = queue.remove();
				
				for (int n : graph[data]) {
					if (B.contains(n) && !visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
			
			// 모든 구역을 방문했는지
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					return;
				}
			}
			
			int result = 0;
			
			// A지역구에 해당하는 인구 수를 더한다.
			for (int p : A) {
				result += people[p];
			}
			
			// B지역구에 해당하는 인구 수를 뺀다.
			for (int p : B) {
				result -= people[p];
			}
			
			// 차이의 최소값을 ans에 저장한다.
			ans = Math.min(ans, Math.abs(result));
			
			return;
		}
		if (pidx == n) {
			return;
		}
		
		A.add(pidx);
		combination(idx + 1, pidx + 1);
		A.pop();
		combination(idx, pidx + 1);
	}
}
