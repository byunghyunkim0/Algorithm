import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String str = sc.next();
        int res = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i - 1) == '(' && str.charAt(i) == ')'){
                stack.pop();
                res += stack.size();
            } else {
                stack.pop();
                res += 1;
            }
        }
        System.out.println(res);
	}
}
