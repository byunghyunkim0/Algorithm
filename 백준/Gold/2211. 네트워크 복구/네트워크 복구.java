import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 네트워크 복구
public class Main {
    static class Node {
        int node;
        int cost;
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        StringBuilder sb = new StringBuilder();

        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;

        int[] trace = new int[n + 1];

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.remove();

            if (cur.cost > distance[cur.node]) {
                continue;
            }

            for (Node next : graph.get(cur.node)) {
                if (distance[next.node] > next.cost + cur.cost) {
                    distance[next.node] = next.cost + cur.cost;
                    queue.add(new Node(next.node, distance[next.node]));
                    trace[next.node] = cur.node;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (trace[i] == 0) {
                continue;
            }
            count++;
            sb.append(i).append(" ").append(trace[i]).append("\n");
        }
        System.out.println(count);
        System.out.print(sb);
    }
}