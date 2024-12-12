import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 미확인 도착지
public class Main {
    static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static List<List<Node>> graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int test = 0; test < tc; test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int ghDist = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
                if ((a == g && b == h) || (b == g && a == h)) {
                    ghDist = d;
                }
            }

            int[] dest = new int[t];
            for (int i = 0; i < t; i++) {
                dest[i] = Integer.parseInt(br.readLine());
            }

            List<Integer> result = new ArrayList<>();
            int[] distance = dijkstra(s);
            int[] startGDist = dijkstra(g);
            int[] startHDist = dijkstra(h);
            for (int end : dest) {
                if (distance[end] == distance[g] + ghDist + startHDist[end]) {
                    result.add(end);
                    continue;
                }
                if (distance[end] == distance[h] + ghDist + startGDist[end]) {
                    result.add(end);
                }
            }

            result.sort(Comparator.comparingInt(o -> o));
            for (int res : result) {
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (distance[cur.idx] < cur.cost) {
                continue;
            }
            for (Node next : graph.get(cur.idx)) {
                if (distance[next.idx] > cur.cost + next.cost) {
                    distance[next.idx] = cur.cost + next.cost;
                    queue.add(new Node(next.idx, distance[next.idx]));
                }
            }
        }
        return distance;
    }
}