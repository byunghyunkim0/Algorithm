import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test = 0; test < 4; test++) {
			int x_1 = sc.nextInt();
			int y_1 = sc.nextInt();
			int p_1 = sc.nextInt();
			int q_1 = sc.nextInt();
			int x_2 = sc.nextInt();
			int y_2 = sc.nextInt();
			int p_2 = sc.nextInt();
			int q_2 = sc.nextInt();
			if ((q_1 < y_2) || (p_1 < x_2) || (q_2 < y_1) || (p_2 < x_1)) {
				System.out.println("d");
			} else if ((p_1 == x_2 && q_1 == y_2) || (p_1 == x_2 && y_1 == q_2) || (p_2 == x_1 && q_2 == y_1) || (p_2 == x_1 && y_2 == q_1)) {
				System.out.println("c");
			} else if ((q_1 == y_2) || (p_1 == x_2) || (q_2 == y_1) || (p_2 == x_1)) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}
}
