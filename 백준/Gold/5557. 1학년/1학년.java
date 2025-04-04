import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1학년
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n - 1][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - arr[i]];
                }
                if (j + arr[i] <= 20) {
                    dp[i][j] += dp[i - 1][j + arr[i]];
                }
            }
        }
        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}