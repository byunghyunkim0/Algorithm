import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 인접 리스트 생성
		List<Integer>[] adjarr = new ArrayList[n + 1];
		// 진입차수에 대한 정보를 담을 배열
		int[] degree = new int[n + 1];
		// 결과값을 저장할 배열
		int[] result = new int[n + 1];
		
		// adjarr를 초기화
		for (int i = 1; i <= n; i++) {
			adjarr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// b 인덱스에 진입차수를 올림
			degree[b]++;
			adjarr[a].add(b);
		}
		
		// queue 생성
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
		
		// queue가 빌때까지
		// 위상정렬알고리즘
		while (!queue.isEmpty()) {
			int data = queue.remove();
			
			System.out.print(data + " ");
			
			for (int i : adjarr[data]) {
				degree[i]--;
				
				if (degree[i] == 0) {
					queue.add(i);
				}
			}
		}
	}
}
