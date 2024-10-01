import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리와 쿼리
public class Main {
    static List<List<Integer>> graph;
    static int[] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            graph.add(temp);
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        graph.get(r).add(r);

        dp = new int[n + 1];
        visited = new boolean[n + 1];
        visited[r] = true;
        dp[r] = dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(dp[u]).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int node) {
        if (graph.get(node).size() == 1) {
            return dp[node] = 1;
        }
        dp[node] = 1;
        for (int next : graph.get(node)) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            dp[node] += dfs(next);
        }
        return dp[node];
    }
}