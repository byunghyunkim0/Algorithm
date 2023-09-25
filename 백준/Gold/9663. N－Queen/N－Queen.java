import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] queen;
	public static int n;
	public static int result = 0;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		queen = new int[n];
		
		visited = new boolean[n];
		
		nqueen(0);
		
		System.out.println(result);
	}
	
	public static void nqueen(int N) {
		if (N == n) {
			result++;
			return;
		}
		
		// queen에 들어갈 수
		t : for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			for (int j = 0; j < N; j++) {
				if (Math.abs(j - N) == Math.abs(queen[j] - i)) {
					continue t;
				}
			}
			queen[N] = i;
			visited[i] = true;
			nqueen(N + 1);
			visited[i] = false;
		}
		
	}
}
