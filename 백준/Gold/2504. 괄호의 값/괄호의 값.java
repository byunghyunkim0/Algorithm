import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<String> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')' || str.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                int temp = 0;
                while (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    tempStack.add(Integer.parseInt(stack.pop()));
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
                }
                if (stack.peek().equals("(") && str.charAt(i) == ')') {
                    if (tempStack.isEmpty()) {
                        temp = 2;
                    }
                    while (!tempStack.isEmpty()) {
                        temp += 2 * tempStack.pop();
                    }
                    stack.pop();
                } else if (stack.peek().equals("[") && str.charAt(i) == ']') {
                    if (tempStack.isEmpty()) {
                        temp = 3;
                    }
                    while (!tempStack.isEmpty()) {
                        temp += 3 * tempStack.pop();
                    }
                    stack.pop();
                } else {
                    System.out.println(0);
                    return;
                }
                stack.add(String.valueOf(temp));
            } else {
                stack.add(String.valueOf(str.charAt(i)));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.equals("(") || cur.equals("[") || cur.equals(")") || cur.equals("]")) {
                System.out.println(0);
                return;
            }
            result += Integer.parseInt(cur);
        }
        System.out.println(result);
    }
}