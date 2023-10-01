import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int count = 0;
		int index = 0;
		int[] data = new int[n];
		while (true) {
			data[index]++;
			if (data[index] == m) {
				break;
			}
			count++;
			index += l;
			if (index >= n) {
				index = index % n;
			}
		}
		System.out.println(count);
		sc.close();
	}
}