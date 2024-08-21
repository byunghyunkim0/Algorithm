import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 암호코드
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        String str = st.nextToken();
        int n = str.length();
        int MOD = 1000000;

        // when
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int cur = str.charAt(i - 1) - '0';

            if (cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            if (i == 1) {
                continue;
            }

            int prev = str.charAt(i - 2) - '0';
            int temp = prev * 10 + cur;
            if (temp >= 10 && temp <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }

        // then
        System.out.println(dp[n]);
    }
}