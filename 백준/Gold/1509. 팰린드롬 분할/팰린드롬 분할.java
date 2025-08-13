import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 팰린드롬 분할
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int n = str.length;
        boolean[][] palindrome = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            palindrome[i][i] = true;

            if (i < n) palindrome[i][i + 1] = (str[i - 1] == str[i]);
        }

        for (int step = 2; step <= n; step++) {
            for (int i = 1; i <= n; i++) {
                if (i + step <= n) {
                    palindrome[i][i + step] = (str[i - 1] == str[i + step - 1] && palindrome[i + 1][i + step - 1]);
                }
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                if (palindrome[i][j]) {
                    dp[j] = Math.min(dp[j], dp[i - 1] + 1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}