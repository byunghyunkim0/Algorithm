import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열4
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int[] result = new int[maxLen];
        for (int i = n - 1; i >= 0; i--) {
            if (maxLen == dp[i]) {
                result[--maxLen] = arr[i];
            }
        }

        // then
        System.out.println(result.length);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}