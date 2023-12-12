
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TEST = sc.nextInt();
		for (int testCase = 1; testCase <= TEST; testCase++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int target = (1 << n) - 1;
			if ((target & m) == target) {
				System.out.println("#" + testCase + " " + "ON");
			} else {
				System.out.println("#" + testCase + " " + "OFF");
			}
		}
		sc.close();
	}
}
