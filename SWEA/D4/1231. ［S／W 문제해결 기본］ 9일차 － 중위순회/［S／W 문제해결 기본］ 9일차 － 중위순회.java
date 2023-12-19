import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int n;
	static String[] tree;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TEST = 10;
		for (int testCase = 1; testCase <= TEST; testCase++) {
			sb = new StringBuilder();
			n = sc.nextInt();
			tree = new String[n + 1];
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				String[] temp = sc.nextLine().split(" ");
				tree[Integer.parseInt(temp[0])] = temp[1];
			}
			sb.append("#" + testCase + " ");
			inorder(1);
			System.out.println(sb);
		}
		sc.close();
	}
	public static void inorder(int num) {
		if (num > n) {
			return;
		}
		inorder(num * 2);
		sb.append(tree[num]);
		inorder(num * 2 + 1);
	}
}
