import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 줄 세우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[arr[i]] = dp[arr[i] - 1] + 1;
            max = Math.max(max, dp[arr[i]]);
        }
        System.out.println(n - max);
    }
}