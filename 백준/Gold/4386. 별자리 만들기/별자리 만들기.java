import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 별의 개수
		int n = sc.nextInt();
		
		// 별의 정보를 저장하기위한 배열 생성
		double[][] stars = new double[n][2];
		
		// 부모 배열 초기화
		parents = new int[n];
		
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		// 별의 정보를 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				stars[i][j] = sc.nextDouble();
			}
		}
		
		// 크루스칼알고리즘을 위해 우선순위 큐 생성
		PriorityQueue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return o1[0] - o2[0] > 0 ? 1:-1;
			}
		});
		
		// 모든 별로 부터 다른 별 사이의 거리를 queue에 추가한다.
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				queue.add(new double[] {Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2)), i, j});
			}
		}
		
		// 간선의 수를 세기
		int count = 0;
		
		// 결과
		double result = 0;
		
		while (count < n - 1) {
			double[] data = queue.remove();
			
			int a = find((int)data[1]);
			int b = find((int)data[2]);
			
			// 사이클이 아니면
			if (a != b) {
				union(a, b);
				result += data[0];
				count++;
			}
		}
		
		System.out.println(result);
	}
	
	// find
	public static int find(int x) {
		if (parents[x] != x) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}
	
	// union
	public static void union(int a, int b) {
		parents[b] = a;
	}
}
