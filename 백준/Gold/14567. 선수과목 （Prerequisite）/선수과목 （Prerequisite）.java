import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 과목의 수
		int n = sc.nextInt();
		// 선수 조건의 수
		int m = sc.nextInt();
		
		List<Integer>[] adjarr = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			adjarr[i] = new ArrayList<>();
		}
		
		int[] degree = new int[n + 1];
		
		int[] result = new int[n];
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 정점 간의 연결 정보 저장
			adjarr[a].add(b);
			
			// 진입차수에 대한 값 설정
			degree[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입차수가 0이면 queue에 삽입
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
		int count = 1;
		
		// 위상정렬 알고리즘
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int data = queue.remove();
				
				for (int index : adjarr[data]) {
					degree[index]--;
					
					if (degree[index] == 0) {
						queue.add(index);
					}
				}
				result[data - 1] = count;
			}
			
			count++;
		}
		
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
