import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = 0;
		double res = 1.0;
		if (c % 5 == 0) {
			d = c / 5;
		} else {
			d = (c / 5) + 1;
		}
		if (c > b * 5) {
			System.out.println(1);
		} else {
			for (int i = 0; i < d; i++) {
				res *= (b - i + 0.0) / (a - i + 0.0);
			}
			System.out.println(1 - res);
			
		}
	}
}
