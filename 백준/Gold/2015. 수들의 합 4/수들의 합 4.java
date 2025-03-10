import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 수들의 합 4
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += count.getOrDefault(sum[i] - k, 0);
            count.put(sum[i], count.getOrDefault(sum[i], 0) + 1);
        }
        System.out.println(result);
    }
}