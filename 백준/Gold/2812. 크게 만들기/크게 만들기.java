import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 크게 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String number = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = number.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            if (k == 0) {
                stack.add(c);
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() >= c || k == 0) {
                    break;
                }
                stack.pop();
                k--;
            }
            stack.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (k != 0) {
                stack.pop();
                k--;
                continue;
            }
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}