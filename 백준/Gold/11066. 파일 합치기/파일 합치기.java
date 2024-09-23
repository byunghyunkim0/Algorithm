import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파일 합치기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] file = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                file[i] = Integer.parseInt(st.nextToken());
                file[i] += file[i - 1];
            }

            // when
            int[][] dp = new int[k][k];
            for (int j = 1; j < k; j++) {
                for (int i = 0; i < k - j; i++) {
                    dp[i][i + j] = Integer.MAX_VALUE;
                    for (int m = i; m < i + j; m++) {
                        dp[i][i + j] = Math.min(dp[i][i + j], dp[i][m] + dp[m + 1][i + j] + file[i + j + 1] - file[i]);
                    }
                }
            }

            // then
            sb.append(dp[0][k - 1]).append("\n");
        }
        System.out.println(sb);
    }
}