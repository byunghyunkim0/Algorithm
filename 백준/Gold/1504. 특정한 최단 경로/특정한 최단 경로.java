import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static List<int[]>[] graph;
	public static int n;
	public static int e;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정점의 개수
		n = sc.nextInt();
		// 간선의 개수
		e = sc.nextInt();
		
		// 인접 리스트 생성
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프의 연결 정보 받기 방향성이 없는 그래프
		for (int i = 0; i < e; i++) {
			// 두 정점 a,b를 이동하는데 걸리는 비용 c
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			// 열견된 정점에 비용, 연결된 노드의 순서로 저장
			graph[a].add(new int[] {c, b});
			graph[b].add(new int[] {c, a});
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		
		// 해당 정점으로부터 다른 정점까지의 거리
		int[] start = dijstra(1);
		int[] disv1 = dijstra(v1);
		int[] disv2 = dijstra(v2);
		
		// start -> v1 -> v2 -> n
		// start -> v2 -> v1 -> n
		// 해당 정점중에서 maxvalue가 있다면 연결 할수없다는 뜻이므로 -1을 출력한다.
		if (start[1] == Integer.MAX_VALUE || start[v1] == Integer.MAX_VALUE || start[v2] == Integer.MAX_VALUE || start[n] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			int result = Math.min(start[v1] + disv1[v2] + disv2[n], start[v2] + disv2[v1] + disv1[n]);
			System.out.println(result);
		}
		
	}
	
	// 시작 정점으로 부터 다른 정점으로 갈수있는 거리에 대한 정보를 리턴하는 메서드
	public static int[] dijstra(int start) {
		// 거리에 대한 정보
		int[] distance = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		// 비용을 기준으로 오름차순의 순서로 데이터를 뽑기위한 우선순위큐 생성
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// 다익스트라
		// 시작 지점에 대한 정보 저장
		distance[start] = 0;
		queue.add(new int[] {0, start});
		
		while (!queue.isEmpty()) {
			// queue가 빌때까지
			int[] data = queue.remove();
			
			// data와 연결된 정점에 대해서 거리를 구하고 거리가 distance의 거리보다 작으면 거리의 값을 갱신하고 queue에 넣는다.
			for (int[] end : graph[data[1]]) {
				int cost = data[0] + end[0];
				
				if (distance[end[1]] > cost) {
					distance[end[1]] = cost;
					queue.add(new int[] {cost, end[1]});
				}
			}
		}
		
		return distance;
	}
}
