import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}
		
		int t = sc.nextInt();
		for (int test = 0; test < t; test++) {
			int sex = sc.nextInt();
			int number = sc.nextInt();
			int right_index = number - 1;
			int left_index = number - 1;
			if (sex == 1) {
				for (int i = number - 1; i < n; i += number) {
					if (s[i] == 1) {
						s[i] = 0;
					} else {
						s[i] = 1;
					}
				}
			} else {
				while (true) {
					if (right_index >= n || left_index < 0) {
						break;
					}
					if (s[right_index] == s[left_index]) {
						if (s[right_index] == 1) {
							s[right_index] = 0;
							s[left_index] = 0;
						} else {
							s[right_index] = 1;
							s[left_index] = 1;
						}
						right_index++;
						left_index--;
					} else {
                        break;
                    }
				}
			}
		}
		for (int i = 1; i < s.length + 1; i++) {
			if (i % 20 == 0) {
				System.out.print(s[i - 1] + " ");
				System.out.println();
			} else {
				System.out.print(s[i - 1] + " ");
			}
		}
		sc.close();
	}
}
