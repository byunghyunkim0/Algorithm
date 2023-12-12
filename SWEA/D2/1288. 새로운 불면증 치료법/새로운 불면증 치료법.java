import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int TEST = sc.nextInt();
		int target = (1 << 10) - 1;
		for (int testCase = 1; testCase <= TEST; testCase++) {
			int n = sc.nextInt();
			int visited = 0;
			int count = 0;
			while (true) {
				char[] arr = String.valueOf(n * ++count).toCharArray();
				for (char num : arr) {
					visited = visited | (1 << (num - '0'));
				}
				if (visited == target) {
					break;
				}
			}
			System.out.println("#" + testCase + " " + (n * count));
		}
		sc.close();
	}
}
