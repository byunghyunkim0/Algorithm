import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우주신과의 교감
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        int cur;
        int next;
        double cost;
        public Node(int cur, int next, double cost) {
            this.cur = cur;
            this.next = next;
            this.cost = cost;
        }
    }
    static int n;
    static Point[] points;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        double[][] distance = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = getDistance(points[i], points[j]);
            }
        }

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            distance[a][b] = 0;
            distance[b][a] = 0;
            union(a, b);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.cost));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == 0) {
                    continue;
                }
                pq.add(new Node(i, j, distance[i][j]));
            }
        }

        double result = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            if (find(cur.cur) == find(cur.next)) {
                continue;
            }
            union(cur.cur, cur.next);
            result += cur.cost;
        }
        System.out.printf("%.2f", result);
    }

    static int find(int a) {
        if (parents[a] != a) {
            return parents[a] = find(parents[a]);
        }
        return a;
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parents[pb] = pa;
    }

    static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));
    }
}