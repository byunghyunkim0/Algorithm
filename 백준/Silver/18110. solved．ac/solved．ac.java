import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] score = new int[n];
		
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(bf.readLine());
		}
		
		double a = Math.round(n * 0.15);
		Arrays.sort(score);
		
		int result = 0;
		for (int i = (int)a; i < n - a; i++) {
			result += score[i];
		}
		
		System.out.println(Math.round(result / (n - (2 * a))));
	}
}
