import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
public class Main {
    static class Node {
        int child;
        int cost;
        public Node(int child, int cost) {
            this.child = child;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static int[] dp;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int par = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[par].add(new Node(child, cost));
        }

        // when
        result = 0;
        dp = new int[n + 1];
        dfs(1);

        // then
        System.out.println(result);
    }

    static int dfs(int cur) {
        if (dp[cur] != 0) {
            return dp[cur];
        }
        if (!graph[cur].isEmpty()) {
            int first = 0;
            int second = 0;

            for (int i = 0; i < graph[cur].size(); i++) {
                int temp = dfs(graph[cur].get(i).child) + graph[cur].get(i).cost;
                if (first < temp) {
                    second = first;
                    first = temp;
                } else if (second < temp) {
                    second = temp;
                }
            }
            result = Math.max(result, first + second);
            return dp[cur] = first;
        }
        return 0;
    }
}