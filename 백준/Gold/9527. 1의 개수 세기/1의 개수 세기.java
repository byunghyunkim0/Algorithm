import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1의 개수 세기
public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        dp = new long[55];
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = 2 * dp[i - 1] + (1L << i);
        }

        long result = calculator(b) - calculator(a - 1);

        System.out.println(result);
    }

    static long calculator(long n) {
        long ans = n & 1;

        for (int i = 54; i > 0; i--) {
            if ((n & (1L << i)) > 0) {
                ans += dp[i - 1] + (n - (1L << i) + 1);
                n -= (1L << i);
            }
        }
        return ans;
    }
}