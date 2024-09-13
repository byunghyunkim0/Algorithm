import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위 표기식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        String str = br.readLine();

        // when
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                sb.append(temp);
            } else if (temp == '(') {
                stack.add('(');
            } else if (temp == ')') {
                while (true) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        sb.append(stack.pop());
                    }

                }
            } else if (temp == '+' || temp == '-') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.add(temp);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') {
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.add(temp);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // then
        System.out.println(sb);
    }
}