import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 물대기
public class Main {
    static class Cost {
        int nodeCost;
        int edgeCost;
        public Cost(int nodeCost, int edgeCost) {
            this.nodeCost = nodeCost;
            this.edgeCost = edgeCost;
        }
    }
    static class Edge {
        int start;
        int end;
        int cost;
        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Cost[] cost = new Cost[n + 1];
        for (int i = 1; i <= n; i++) {
            cost[i] = new Cost(Integer.parseInt(br.readLine()), 0);
        }

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (i >= j) {
                    st.nextToken();
                    continue;
                }
                edges.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        while (!edges.isEmpty()) {
            Edge cur = edges.remove();
            int pa = find(cur.start);
            int pb = find(cur.end);
            if (pa == pb) {
                continue;
            }
            if (cost[pa].nodeCost + cost[pb].nodeCost > Math.min(cost[pa].nodeCost, cost[pb].nodeCost) + cur.cost) {
                union(pa, pb);
                cost[find(pa)].nodeCost = Math.min(cost[pa].nodeCost, cost[pb].nodeCost);
                cost[find(pa)].edgeCost = cost[pa].edgeCost + cost[pb].edgeCost + cur.cost;
            }
        }
        int res = 0;
        boolean[] check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (check[parents[i]]) {
                continue;
            }
            check[parents[i]] = true;
            res += cost[parents[i]].edgeCost + cost[parents[i]].nodeCost;
        }
        System.out.println(res);
    }

    static int find(int x) {
        if (parents[x] != x) {
            return parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int a, int b) {
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}