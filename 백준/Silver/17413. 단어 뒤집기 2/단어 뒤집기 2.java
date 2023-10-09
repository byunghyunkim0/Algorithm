import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 뒤집을 문자열 받기
		String str = sc.nextLine();
		str.replace("\n", " ");
		boolean flag = false;
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				while (!(stack.isEmpty())) {
					System.out.print(stack.pop());
				}
				flag = true;
				System.out.print(str.charAt(i));
			} else if (str.charAt(i) == '>') {
				flag = false;
				System.out.print(str.charAt(i));
			} else if (flag == true) {
				System.out.print(str.charAt(i));
			} else if (str.charAt(i) != ' '){
				stack.push(str.charAt(i));
			} else {
				while (!(stack.isEmpty())) {
					System.out.print(stack.pop());
				}
				System.out.print(str.charAt(i));
			}
		}
		
		while (!(stack.isEmpty())) {
			System.out.print(stack.pop());
		}
	}
}
