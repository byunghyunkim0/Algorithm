import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 사회망 서비스(SNS)
public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        if (dp[node][1] > 0) {
            return;
        }
        dp[node][1] = 1;
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (dp[next][1] > 0) {
                continue;
            }
            dfs(next);
            dp[node][0] += dp[next][1];
            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}