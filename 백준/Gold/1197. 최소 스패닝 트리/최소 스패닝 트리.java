import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 노드의 개수
		int v = sc.nextInt();
		// 간선의 개수
		int e = sc.nextInt();
		
		parents = new int[v + 1];
		int result = 0;
		
		// make-set
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
		
		// 비용을 기준으로 작은것부터 나오도록 하기위한 우선순위 큐
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			// int[] 객체이기때문에 첫번째를 기준으로 오름차순으로 정렬하기위해서 compare작성
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < e; i++) {
			// a, b : a와 b가 연결되어있다.
			// c : 해당 연결에 대한 가중치
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			// 가중치, a, b를 우선순위큐에 저장
			queue.add(new int[] {c, a, b});
		}
		
		for (int i = 0; i < e; i++) {
			// 우선순위 큐에서 가중치가 작은것을 뽑는다.
			int[] data = queue.remove();
			
			if (find(data[1]) != find(data[2])) {
				union(data[1], data[2]);
				result += data[0];
			}
		}
		System.out.println(result);
	}
	
	// 부모를 찾는 메서드
	public static int find(int x) {
		if (parents[x] != x) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}
	
	// 합치는 메서드
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parents[b] = a;
		}
	}
}
