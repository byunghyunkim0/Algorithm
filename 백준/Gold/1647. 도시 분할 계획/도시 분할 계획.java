import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도시
public class Main {
    static class Edge {
        int a;
        int b;
        int c;
        public Edge (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new Edge(a, b, c));
        }

        int result = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Edge cur = queue.remove();
            if (find(cur.a) != find(cur.b)) {
                union(cur.a, cur.b);
                result += cur.c;
                max = Math.max(max, cur.c);
            }
        }

        System.out.println(result - max);
    }

    static int find (int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    static void union (int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            parent[y] = x;
        }
    }
}