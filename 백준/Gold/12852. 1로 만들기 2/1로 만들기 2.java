import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1로 만들기 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] trace = new int[n + 1];

        Arrays.fill(dp, 1000001);
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    trace[i] = i / 2;
                }
            }

            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                    trace[i] = i / 3;
                }
            }

            if (dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                trace[i] = i - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        int idx = n;
        while (trace[idx] != 0) {
            sb.append(idx).append(" ");
            idx = trace[idx];
        }
        sb.append(1);

        System.out.print(sb);
    }
}