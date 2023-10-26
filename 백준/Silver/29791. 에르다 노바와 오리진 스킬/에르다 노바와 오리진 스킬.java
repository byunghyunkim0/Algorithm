import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] nova = new int[n];
		int[] origin = new int[m];
		
		for (int i = 0; i < n; i++) {
			nova[i] = sc.nextInt();
		}
		Arrays.sort(nova);
		int no = nova[0];
		int noCount = 1;
		for (int i = 1; i < n; i++) {
			if (no + 100 <= nova[i]) {
				no = nova[i];
				noCount++;
			}
		}
		
		int ori = origin[0];
		int oriCount = 1;
		for (int i = 0; i < m; i++) {
			origin[i] = sc.nextInt();
		}
		
		Arrays.sort(origin);
		
		for (int i = 1; i < m; i++) {
			if (ori + 360 <= origin[i]) {
				ori = origin[i];
				oriCount++;
			}
		}
		System.out.println(noCount + " " + oriCount);
	}
}
