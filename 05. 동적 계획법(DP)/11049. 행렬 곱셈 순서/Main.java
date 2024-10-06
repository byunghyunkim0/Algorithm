import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 곱셈 순서
public class Main {
    static class Matrix {
        int r;
        int c;
        public Matrix (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // given
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        Matrix[] matrices = new Matrix[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            matrices[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // when
        int[] d = new int[n + 1];
        d[0] = matrices[0].r;
        for (int i = 0; i < n; i++) {
            d[i + 1] = matrices[i].c;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + d[i - 1] * d[k] * d[j]);
                }
            }
        }

        // then
        System.out.println(dp[1][n]);
    }
}