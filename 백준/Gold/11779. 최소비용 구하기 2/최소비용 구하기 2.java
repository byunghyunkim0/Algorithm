import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소비용 구하기 2
public class Main {
    static class Node {
        int idx;
        int cost;
        public Node (int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Node> temp = new ArrayList<>();
            graph.add(temp);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(cur).add(new Node(next, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        int[] trace = new int[n + 1];
        trace[start] = -1;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (distance[cur.idx] < cur.cost) {
                continue;
            }
            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);
                if (distance[next.idx] > cur.cost + next.cost) {
                    distance[next.idx] = cur.cost + next.cost;
                    queue.add(new Node(next.idx, distance[next.idx]));
                    trace[next.idx] = cur.idx;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> temp = new ArrayList<>();
        int idx = end;
        while (true) {
            temp.add(idx);
            idx = trace[idx];
            if (trace[idx] == -1) {
                temp.add(idx);
                break;
            }
        }
        sb.append(distance[end]).append("\n");
        sb.append(temp.size()).append("\n");
        for (int i = temp.size() - 1; i >= 0; i--) {
            sb.append(temp.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}