import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 웜홀
public class Main {
    static class Edge {
        int cur;
        int next;
        int cost;
        public Edge (int cur, int next, int cost) {
            this.cur = cur;
            this.next = next;
            this.cost = cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Edge> edges;
    static int n;
    static int m;
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TEST = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TEST; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())));
            }

            boolean flag = bellman();
            if (flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    static boolean bellman() {
        int[] distance = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (Edge edge : edges) {
                distance[edge.next] = Math.min(distance[edge.next], distance[edge.cur] + edge.cost);
            }
        }

        for (Edge edge : edges) {
            if (distance[edge.next] > distance[edge.cur] + edge.cost) {
                return true;
            }
        }
        return false;
    }
}