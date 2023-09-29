import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스는 10개
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 정점의 개수
			int v = sc.nextInt();
			// 간선의 개수
			int e = sc.nextInt();
			
			List<Integer>[] adjarr = new ArrayList[v + 1];
			for (int i = 1; i <= v; i++) {
				adjarr[i] = new ArrayList<>();
			}
			
			// 진입차수에 대한 정보를 담을 배열
			int[] degree = new int[v + 1];
			
			for (int i = 0; i < e; i++) {
				// a노드에서 b노드로 감
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adjarr[a].add(b);
				// 진입차수 +1
				degree[b]++;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			
			// 진입차수가 0인 노드를 queue에 넣음
			for (int i = 1; i <= v; i++) {
				if (degree[i] == 0) {
					queue.add(i);
				}
			}
			System.out.print("#" + testCase);
			
			while (!queue.isEmpty()) {
				int data = queue.remove();
				
				System.out.print(" " + data);
				
				for (int index : adjarr[data]) {
					
					if (--degree[index] == 0) {
						queue.add(index);
					}
				}
			}
			System.out.println();
		}
	}
}
