import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] str = sc.next().split("");
		
		Stack<String> stack = new Stack<>();
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty() || stack.peek().equals(str[i])) {
				stack.add(str[i]);
				result = Math.max(result, stack.size());
			} else {
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}
}
