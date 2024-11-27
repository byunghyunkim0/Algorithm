import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소형기관차
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] train = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            train[i] = Integer.parseInt(st.nextToken());
            train[i] += train[i - 1];
        }
        int max = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][n + 1];

        for (int i = 1; i <= 3; i++) {
            for (int j = i * max; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - max] + train[j] - train[j - max]);
            }
        }

        System.out.println(dp[3][n]);
    }
}