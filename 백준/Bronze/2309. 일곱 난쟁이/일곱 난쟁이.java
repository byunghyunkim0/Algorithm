import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] h = new int[9];
		int sum = 0;
		for (int i = 0; i < h.length; i++) {
			h[i] = sc.nextInt();
			sum += h[i];
		}
		int target = sum - 100;
		int[] index = new int[2];
		for (int i = 0; i < h.length - 1; i++) {
			int temp = h[i];
			index[0] = i;
			for (int j = i; j < h.length; j++) {
				if (temp + h[j] == target) {
					index[1] = j;
					break;
				}
			}
			if (index[1] != 0) {
				break;
			}
		}
		int[] result = new int[7];
		int result_i = 0;
		for (int i = 0; i < h.length; i++) {
			if (!(i == index[0] || i == index[1])) {
				result[result_i++] = h[i];
			}
		}
		Arrays.sort(result);
		for (int r : result) {
			System.out.println(r);
		}
		sc.close();
	}
}
