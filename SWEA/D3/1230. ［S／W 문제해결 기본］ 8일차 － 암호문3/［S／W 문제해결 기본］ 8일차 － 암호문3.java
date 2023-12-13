import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static ArrayList<Integer> list;
	public static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		StringBuilder sb;
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb = new StringBuilder();
			list = new ArrayList<>();
			int n = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			
			int m = sc.nextInt();
			
			for (int i = 0; i < m; i++) {
				char f = sc.next().charAt(0);
				func(f);
			}
			sb.append("#" + testCase);
			for (int i = 0; i < 10; i++) {
				sb.append(" " + list.get(i));
			}
			System.out.println(sb);
		}
		sc.close();
	}
	
	public static void func(char f) {
		if (f == 'I') {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = 0; i < y; i++) {
				list.add(x + i, sc.nextInt());
			}
		} else if (f == 'D') {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = 0; i < y; i++) {
				list.remove(x);
			}
		} else {
			int y = sc.nextInt();
			for (int i = 0; i < y; i++) {
				list.add(sc.nextInt());
			}
		}
	}
}
