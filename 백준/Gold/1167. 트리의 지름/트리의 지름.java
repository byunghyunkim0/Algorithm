import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
public class Main {
    static class Node {
        int next;
        int cost;
        public Node (int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    static List<Node>[] graph;
    static int[] dp;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int v = Integer.parseInt(br.readLine());
        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                graph[cur].add(new Node(next, cost));
            }
        }

        // when
        result = 0;
        dp = new int[v + 1];
        visited = new boolean[v + 1];
        visited[1] = true;
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
                if (!visited[graph[cur].get(i).next]) {
                    visited[graph[cur].get(i).next] = true;
                    int temp = dfs(graph[cur].get(i).next) + graph[cur].get(i).cost;
                    if (first < temp) {
                        second = first;
                        first = temp;
                    } else if (second < temp) {
                        second = temp;
                    }
                }
            }
            result = Math.max(result, first + second);
            return dp[cur] = first;
        }
        return 0;
    }
}