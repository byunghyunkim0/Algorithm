import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 이진수 더하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
            long result = 0;
            if (x == 0) {
                for (Integer number : count.keySet()) {
                    result += (long)count.get(number) * (count.get(number) - 1);
                }
            } else {
                for (Integer number : count.keySet()) {
                    result += (long)count.get(number) * count.getOrDefault(number ^ x, 0);
                }
            }
            sb.append(result >> 1).append("\n");
        }
        System.out.print(sb);
    }
}