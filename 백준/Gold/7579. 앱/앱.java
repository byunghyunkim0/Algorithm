import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 앱
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] data = new int[n + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            data[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][10001];
        int cost = 10000;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= cost; j++) {
                if (j >= data[i][1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - data[i][1]] + data[i][0]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= m) {
                    cost = j;
                }
            }
        }
        System.out.println(cost);
    }
}