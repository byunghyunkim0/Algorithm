import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 텀 프로젝트
public class Main {
    static int[] team;
    static int[] cycle;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            team = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                team[i] = Integer.parseInt(st.nextToken());
            }
            // when
            cycle = new int[n + 1];
            result = n;
            for (int i = 1; i <= n; i++) {
                if (cycle[i] != 0) {
                    continue;
                }
                cycle[i] = 1;
                dfs(i);
                cycle[i] = 100000;
            }
            // then
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int n) {
        if (cycle[team[n]] != 0) {
            if (cycle[team[n]] <= cycle[n]) {
                result -= cycle[n] - cycle[team[n]] + 1;
            }
            return;
        }
        cycle[team[n]] = cycle[n] + 1;
        dfs(team[n]);
        cycle[team[n]] = 100000;
    }
}