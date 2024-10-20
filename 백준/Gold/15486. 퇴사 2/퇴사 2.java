import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] days = new int[n + 2][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        int max = 0;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);
            int day = i + days[i][0];

            if (day <= n + 1) {
                dp[day] = Math.max(dp[day], max + days[i][1]);
            }
        }

        System.out.println(max);
    }
}