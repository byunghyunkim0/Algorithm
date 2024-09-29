import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 타임머신
public class Main {
    static class Node {
        int cur;
        int next;
        int cost;
        public Node (int cur, int next, int cost) {
            this.cur = cur;
            this.next = next;
            this.cost = cost;
        }
    }
    static List<Node> graph;
    static final long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Node(a, b, cost));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Node node = graph.get(j);

                if (dist[node.cur] != Long.MAX_VALUE && dist[node.next] > dist[node.cur] + node.cost) {
                    dist[node.next] = dist[node.cur] + node.cost;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Node node = graph.get(i);

            if (dist[node.cur] != Long.MAX_VALUE && dist[node.next] > dist[node.cur] + node.cost) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}