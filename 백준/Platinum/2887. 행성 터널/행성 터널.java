import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 행성 터널
public class Main {
    static class Point {
        int idx;
        int x;
        int y;
        int z;
        public Point(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

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
    static int n;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        Arrays.sort(points, Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < n - 1; i++) {
            int cost = Math.abs(points[i].x - points[i + 1].x);
            queue.add(new Node(points[i].idx, points[i + 1].idx, cost));
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o.y));
        for (int i = 0; i < n - 1; i++) {
            int cost = Math.abs(points[i].y - points[i + 1].y);
            queue.add(new Node(points[i].idx, points[i + 1].idx, cost));
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o.z));
        for (int i = 0; i < n - 1; i++) {
            int cost = Math.abs(points[i].z - points[i + 1].z);
            queue.add(new Node(points[i].idx, points[i + 1].idx, cost));
        }

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int minCost = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (find(cur.cur) != find(cur.next)) {
                union(cur.cur, cur.next);
                minCost += cur.cost;
            }
        }
        System.out.println(minCost);
    }

    static int find(int x) {
        if (parents[x] != x) {
            return parents[x] = find(parents[x]);
        }
        return x;
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parents[pa] = pb;
        }
    }
}