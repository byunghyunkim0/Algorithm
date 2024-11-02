import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 오등큰수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[1000001];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                if (count[arr[stack.peek()]] >= count[arr[i]]) {
                    break;
                }
                result[stack.pop()] = arr[i];
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            sb.append(res).append(" ");
        }
        System.out.println(sb);
    }
}