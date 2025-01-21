import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 2
public class Main {
    static class Pipe {
        int wall;
        long w;
        long c;
        long h;
        public Pipe(int wall) {
            this.wall = wall;
            this.w = 0;
            this.c = 0;
            this.h = 0;
        }
        public long sum() {
            return w + c + h;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Pipe[][] dp = new Pipe[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = new Pipe(0);
            dp[i][0] = new Pipe(0);
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = new Pipe(Integer.parseInt(st.nextToken()));
            }
        }
        dp[1][2].w = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j].wall == 1) {
                    continue;
                }
                dp[i][j].w += dp[i][j - 1].w + dp[i][j - 1].c;
                dp[i][j].h += dp[i - 1][j].h + dp[i - 1][j].c;
                if (dp[i - 1][j].wall == 0 && dp[i][j - 1].wall == 0) {
                    dp[i][j].c += dp[i - 1][j - 1].w + dp[i - 1][j - 1].h + dp[i - 1][j - 1].c;
                }
            }
        }
        System.out.println(dp[n][n].sum());
    }
}