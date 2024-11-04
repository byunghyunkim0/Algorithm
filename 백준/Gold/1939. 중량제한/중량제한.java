import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 중량제한
public class Main {
    static class Node {
        int node;
        int weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    static int n;
    static List<Node>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            max = Math.max(cost, max);
            min = Math.min(cost, min);
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        while (min <= max) {
            visited = new boolean[n + 1];
            int mid = (max + min) / 2;
            if (check(start, end, mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

    static boolean check(int start, int end, int weight) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            if (cur == end) {
                return true;
            }
            for (Node next : graph[cur]) {
                if (next.weight >= weight && !visited[next.node]) {
                    visited[next.node] = true;
                    queue.add(next.node);
                }
            }
        }
        return false;
    }
}